#!/usr/bin/env python3
"""
Texture generator for UsefulToolsMod.
Extracts vanilla MC textures and mod base textures, then applies HSV color
remapping to produce vibrant, distinctive tool/armor/material textures.

Jagged/rough tools use jobsidian PNGs as the shape framework.
Smooth/higher-tier tools use vanilla tool shapes.
Armor uses vanilla armor shapes.
Overpower and stone rock variants are NOT touched.
"""

import colorsys
import os
import zipfile
from pathlib import Path
from PIL import Image

# ---------------------------------------------------------------------------
# Paths
# ---------------------------------------------------------------------------
CLIENT_JAR = os.path.expanduser(
    "~/.gradle/caches/forge_gradle/minecraft_repo/versions/1.21.1/client-extra.jar"
)
TEX_ROOT = Path("src/main/resources/assets/usefultoolsmod/textures")
ITEM_DIR = TEX_ROOT / "item"
ARMOR_DIR = TEX_ROOT / "models" / "armor"

# ---------------------------------------------------------------------------
# Vanilla texture paths inside the jar
# ---------------------------------------------------------------------------
V_ITEM = "assets/minecraft/textures/item"
V_ARMOR = "assets/minecraft/textures/models/armor"

TOOL_TYPES = ["sword", "pickaxe", "axe", "shovel", "hoe"]
ARMOR_PIECES = ["helmet", "chestplate", "leggings", "boots"]


def extract_png(jar_path: str, internal_path: str) -> Image.Image:
    """Extract a PNG from a jar (zip) file and return as RGBA Image."""
    with zipfile.ZipFile(jar_path, "r") as zf:
        with zf.open(internal_path) as f:
            img = Image.open(f).convert("RGBA")
            img.load()
            return img


def load_local_png(path: str | Path) -> Image.Image:
    """Load a local PNG file as RGBA Image."""
    img = Image.open(path).convert("RGBA")
    img.load()
    return img


# ---------------------------------------------------------------------------
# Color remapping
# ---------------------------------------------------------------------------

def remap_hsv(img: Image.Image, *, target_hue: float | None = None,
              sat_mult: float = 1.0, sat_set: float | None = None,
              val_mult: float = 1.0, val_add: float = 0.0,
              hue_shift: float | None = None) -> Image.Image:
    """
    Per-pixel HSV remapping.  Preserves alpha.

    target_hue : if set, all pixels get this hue (0-360)
    hue_shift  : if set (and target_hue is None), shift existing hue by this amount
    sat_mult   : multiply saturation
    sat_set    : if set, force saturation to this value (0-1)
    val_mult   : multiply value
    val_add    : add to value after mult
    """
    out = img.copy()
    px = out.load()
    w, h = out.size

    for y in range(h):
        for x in range(w):
            r, g, b, a = px[x, y]
            if a == 0:
                continue

            rn, gn, bn = r / 255.0, g / 255.0, b / 255.0
            h_val, s_val, v_val = colorsys.rgb_to_hsv(rn, gn, bn)

            # Hue
            if target_hue is not None:
                h_val = target_hue / 360.0
            elif hue_shift is not None:
                h_val = (h_val + hue_shift / 360.0) % 1.0

            # Saturation
            if sat_set is not None:
                s_val = sat_set
            else:
                s_val = min(1.0, s_val * sat_mult)

            # Value
            v_val = min(1.0, max(0.0, v_val * val_mult + val_add))

            rn, gn, bn = colorsys.hsv_to_rgb(h_val, s_val, v_val)
            px[x, y] = (int(rn * 255), int(gn * 255), int(bn * 255), a)

    return out


def blend_tint(img: Image.Image, tint_rgb: tuple[int, int, int],
               strength: float = 0.4) -> Image.Image:
    """Blend each pixel toward a tint color.  Preserves luminance shape."""
    out = img.copy()
    px = out.load()
    w, h = out.size
    tr, tg, tb = tint_rgb

    for y in range(h):
        for x in range(w):
            r, g, b, a = px[x, y]
            if a == 0:
                continue
            nr = int(r * (1 - strength) + tr * strength)
            ng = int(g * (1 - strength) + tg * strength)
            nb = int(b * (1 - strength) + tb * strength)
            px[x, y] = (min(255, nr), min(255, ng), min(255, nb), a)

    return out


# ---------------------------------------------------------------------------
# Helper: generate a full tool set from a base
# ---------------------------------------------------------------------------

def gen_tools(bases: dict[str, Image.Image], prefix: str,
              remap_fn=None, **remap_kwargs):
    """Generate 5 tool textures from base images. remap_fn defaults to remap_hsv."""
    count = 0
    if remap_fn is None:
        remap_fn = remap_hsv
    for tool in TOOL_TYPES:
        out = remap_fn(bases[tool], **remap_kwargs)
        out.save(ITEM_DIR / f"{prefix}_{tool}.png")
        count += 1
    print(f"  {prefix}: {count} tools")
    return count


def gen_armor_items(bases: dict[str, Image.Image], prefix: str,
                    remap_fn=None, **remap_kwargs):
    """Generate 4 armor item icons from base images."""
    count = 0
    if remap_fn is None:
        remap_fn = remap_hsv
    for piece in ARMOR_PIECES:
        out = remap_fn(bases[piece], **remap_kwargs)
        out.save(ITEM_DIR / f"{prefix}_{piece}.png")
        count += 1
    print(f"  {prefix}: {count} armor items")
    return count


def gen_armor_layers(base_l1: Image.Image, base_l2: Image.Image, prefix: str,
                     remap_fn=None, **remap_kwargs):
    """Generate layer_1 and layer_2 armor model textures."""
    if remap_fn is None:
        remap_fn = remap_hsv
    l1 = remap_fn(base_l1, **remap_kwargs)
    l2 = remap_fn(base_l2, **remap_kwargs)
    l1.save(ARMOR_DIR / f"{prefix}_layer_1.png")
    l2.save(ARMOR_DIR / f"{prefix}_layer_2.png")
    print(f"  {prefix}: 2 armor layers")
    return 2


# ---------------------------------------------------------------------------
# Composite remap functions for multi-step transforms
# ---------------------------------------------------------------------------

def remap_rgold_tool(img, **_):
    """Rgold tools: iron base blended with gold tint, vibrant."""
    out = blend_tint(img, (218, 175, 42), strength=0.55)
    return remap_hsv(out, hue_shift=5, sat_mult=1.4, val_mult=1.05)


def remap_rgold_armor(img, **_):
    """Rgold armor items: golden base with slight iron tint, vibrant."""
    out = blend_tint(img, (170, 170, 180), strength=0.3)
    return remap_hsv(out, hue_shift=5, sat_mult=1.3, val_mult=1.0)


def remap_rgold_layers(img, **_):
    """Rgold armor layers: iron base with strong gold tint."""
    out = blend_tint(img, (218, 165, 32), strength=0.55)
    return remap_hsv(out, hue_shift=5, sat_mult=1.3, val_mult=1.05)


def remap_hred_tool(img, **_):
    """Hardened redstone tools: vibrant deep red."""
    return remap_hsv(img, target_hue=0, sat_set=0.85, val_mult=0.8)


def remap_hred_armor(img, **_):
    """Hardened redstone armor: vibrant red."""
    return remap_hsv(img, target_hue=0, sat_set=0.8, val_mult=0.85)


def remap_coal_tool(img, **_):
    """Coal tools: very dark grey, low saturation."""
    return remap_hsv(img, target_hue=0, sat_set=0.05, val_mult=0.35)


def remap_coal_armor(img, **_):
    """Coal armor: dark charcoal grey."""
    return remap_hsv(img, target_hue=0, sat_set=0.05, val_mult=0.35)


def remap_fni_tool(img, **_):
    """FNI tools: iron-flint blend, warm grey with orange accent."""
    out = blend_tint(img, (180, 140, 100), strength=0.35)
    return remap_hsv(out, hue_shift=10, sat_mult=1.3, val_mult=0.85)


def remap_fni_armor(img, **_):
    """FNI armor: warm iron-flint blend."""
    out = blend_tint(img, (180, 140, 100), strength=0.3)
    return remap_hsv(out, hue_shift=10, sat_mult=1.2, val_mult=0.88)


def remap_obsidian_armor(img, **_):
    """Obsidian armor: deep purple-black, vibrant."""
    return remap_hsv(img, target_hue=275, sat_set=0.6, val_mult=0.45)


def remap_emerald_armor(img, **_):
    """Emerald armor: vivid green."""
    return remap_hsv(img, target_hue=140, sat_set=0.8, val_mult=0.85)


# ---------------------------------------------------------------------------
# Jagged tool color configs (applied to jobsidian base shapes)
# ---------------------------------------------------------------------------

JAGGED_TOOL_CONFIGS = {
    # name: remap_kwargs or callable
    "jemerald": {"target_hue": 140, "sat_set": 0.85, "val_mult": 0.9},
    "jamethyst": {"target_hue": 280, "sat_set": 0.7, "val_mult": 0.8},
    "jquartz": {"target_hue": 35, "sat_set": 0.12, "val_mult": 1.2, "val_add": 0.08},
    "jprism": {"target_hue": 170, "sat_set": 0.7, "val_mult": 0.75},
    "jflint": {"target_hue": 30, "sat_set": 0.15, "val_mult": 0.5},
    "snow": {"target_hue": 200, "sat_set": 0.15, "val_mult": 1.3, "val_add": 0.15},
    "ice": {"target_hue": 195, "sat_set": 0.65, "val_mult": 0.95},
    "jraw_gold": {"target_hue": 45, "sat_set": 0.8, "val_mult": 0.9},
    "jraw_copper": {"target_hue": 25, "sat_set": 0.75, "val_mult": 0.8},
    "jraw_iron": {"target_hue": 25, "sat_set": 0.12, "val_mult": 0.7},
    "jraw_rgold": {"target_hue": 42, "sat_set": 0.6, "val_mult": 0.8},
    "jscrap": {"target_hue": 30, "sat_set": 0.25, "val_mult": 0.4},
}


# ---------------------------------------------------------------------------
# Smooth tool color configs (applied to vanilla tool shapes)
# ---------------------------------------------------------------------------

SMOOTH_TOOL_CONFIGS = {
    # name: (vanilla_base_prefix, remap_kwargs_or_callable)
    # Diamond-based smooth tools
    "semerald": ("diamond", {"target_hue": 140, "sat_set": 0.8, "val_mult": 0.9}),
    "rlapis": ("diamond", {"target_hue": 230, "sat_set": 0.8, "val_mult": 0.75}),
    "camethyst": ("diamond", {"target_hue": 280, "sat_set": 0.65, "val_mult": 0.85}),
    "squartz": ("diamond", {"target_hue": 35, "sat_set": 0.1, "val_mult": 1.2, "val_add": 0.08}),
    "sprism": ("diamond", {"target_hue": 170, "sat_set": 0.65, "val_mult": 0.8}),
    # Iron-based smooth tools
    "hredstone": ("iron", "remap_hred_tool"),
    "hglowstone": ("iron", {"target_hue": 41, "sat_set": 0.75, "val_mult": 1.1}),
    "coal": ("iron", "remap_coal_tool"),
    "fni": ("iron", "remap_fni_tool"),
    "rgold": ("iron", "remap_rgold_tool"),
}


# ---------------------------------------------------------------------------
# Armor configs (item icons + model layers)
# ---------------------------------------------------------------------------

# (vanilla_item_base, vanilla_layer_base, remap_kwargs_or_callable)
ARMOR_CONFIGS = {
    # Diamond-based armor
    "rlapis": ("diamond", "diamond", {"target_hue": 230, "sat_set": 0.8, "val_mult": 0.75}),
    "camethyst": ("diamond", "diamond", {"target_hue": 280, "sat_set": 0.6, "val_mult": 0.85}),
    "squartz": ("diamond", "diamond", {"target_hue": 35, "sat_set": 0.1, "val_mult": 1.2, "val_add": 0.08}),
    "ice": ("diamond", "diamond", {"target_hue": 195, "sat_set": 0.65, "val_mult": 1.05}),
    "sprism": ("diamond", "diamond", {"target_hue": 170, "sat_set": 0.65, "val_mult": 0.8}),
    "obsidian": ("netherite", "netherite", "remap_obsidian_armor"),
    "emerald": ("diamond", "diamond", "remap_emerald_armor"),
    # Iron-based armor
    "hred": ("iron", "iron", "remap_hred_armor"),
    "hglow": ("iron", "iron", {"target_hue": 41, "sat_set": 0.7, "val_mult": 1.1}),
    "coal": ("iron", "iron", "remap_coal_armor"),
    "fni": ("iron", "iron", "remap_fni_armor"),
    # Special base armors
    "rgold": ("golden", "iron", "remap_rgold"),
}


# ---------------------------------------------------------------------------
# Resolve remap function
# ---------------------------------------------------------------------------

NAMED_REMAPS = {
    "remap_rgold_tool": remap_rgold_tool,
    "remap_rgold_armor": remap_rgold_armor,
    "remap_rgold_layers": remap_rgold_layers,
    "remap_hred_tool": remap_hred_tool,
    "remap_hred_armor": remap_hred_armor,
    "remap_coal_tool": remap_coal_tool,
    "remap_coal_armor": remap_coal_armor,
    "remap_fni_tool": remap_fni_tool,
    "remap_fni_armor": remap_fni_armor,
    "remap_obsidian_armor": remap_obsidian_armor,
    "remap_emerald_armor": remap_emerald_armor,
    "remap_rgold": remap_rgold_armor,
}


def resolve_remap(spec):
    """Given a dict of kwargs or a string function name, return (fn, kwargs)."""
    if isinstance(spec, str):
        return NAMED_REMAPS[spec], {}
    elif isinstance(spec, dict):
        return remap_hsv, spec
    else:
        raise ValueError(f"Unknown remap spec: {spec}")


# ---------------------------------------------------------------------------
# Generation functions
# ---------------------------------------------------------------------------

def generate_jagged_tools():
    """Generate all jagged/rough tool textures using jobsidian as base shape."""
    print("=== Jagged Tools (jobsidian base) ===")

    # Load jobsidian base shapes
    jobsidian = {}
    for tool in TOOL_TYPES:
        jobsidian[tool] = load_local_png(ITEM_DIR / f"jobsidian_{tool}.png")

    total = 0
    for name, spec in JAGGED_TOOL_CONFIGS.items():
        fn, kwargs = resolve_remap(spec)
        total += gen_tools(jobsidian, name, remap_fn=fn, **kwargs)

    return total


def generate_smooth_tools():
    """Generate all smooth/higher-tier tool textures using vanilla tool shapes."""
    print("\n=== Smooth Tools (vanilla base) ===")

    # Cache vanilla tool bases
    vanilla_tools = {}
    for base_prefix in ("diamond", "iron", "golden", "netherite"):
        vanilla_tools[base_prefix] = {}
        for tool in TOOL_TYPES:
            vanilla_tools[base_prefix][tool] = extract_png(
                CLIENT_JAR, f"{V_ITEM}/{base_prefix}_{tool}.png"
            )

    total = 0
    for name, (base_prefix, spec) in SMOOTH_TOOL_CONFIGS.items():
        fn, kwargs = resolve_remap(spec)
        total += gen_tools(vanilla_tools[base_prefix], name, remap_fn=fn, **kwargs)

    return total


def generate_armor_items_all():
    """Generate all armor item icon textures."""
    print("\n=== Armor Item Icons ===")

    # Cache vanilla armor item bases
    vanilla_armor = {}
    for base_prefix in ("diamond", "iron", "golden", "netherite", "chainmail"):
        vanilla_armor[base_prefix] = {}
        for piece in ARMOR_PIECES:
            vanilla_armor[base_prefix][piece] = extract_png(
                CLIENT_JAR, f"{V_ITEM}/{base_prefix}_{piece}.png"
            )

    total = 0
    for name, (item_base, _, spec) in ARMOR_CONFIGS.items():
        fn, kwargs = resolve_remap(spec)
        total += gen_armor_items(vanilla_armor[item_base], name, remap_fn=fn, **kwargs)

    return total


def generate_armor_layers_all():
    """Generate all armor model layer textures."""
    print("\n=== Armor Model Layers ===")

    # Cache vanilla armor layer bases
    vanilla_layers = {}
    for base_prefix in ("diamond", "iron", "gold", "netherite", "chainmail"):
        vanilla_layers[base_prefix] = (
            extract_png(CLIENT_JAR, f"{V_ARMOR}/{base_prefix}_layer_1.png"),
            extract_png(CLIENT_JAR, f"{V_ARMOR}/{base_prefix}_layer_2.png"),
        )

    total = 0
    for name, (_, layer_base, spec) in ARMOR_CONFIGS.items():
        # Special handling for rgold layers (different transform than item icons)
        if name == "rgold":
            fn, kwargs = remap_rgold_layers, {}
        else:
            fn, kwargs = resolve_remap(spec)

        bl1, bl2 = vanilla_layers[layer_base]
        total += gen_armor_layers(bl1, bl2, name, remap_fn=fn, **kwargs)

    return total


def generate_material_items():
    """Generate crystal/element material item textures."""
    print("\n=== Material Items ===")

    amethyst_shard = extract_png(CLIENT_JAR, f"{V_ITEM}/amethyst_shard.png")
    prismarine_shard = extract_png(CLIENT_JAR, f"{V_ITEM}/prismarine_shard.png")
    quartz = extract_png(CLIENT_JAR, f"{V_ITEM}/quartz.png")
    gold_ingot = extract_png(CLIENT_JAR, f"{V_ITEM}/gold_ingot.png")
    coal = extract_png(CLIENT_JAR, f"{V_ITEM}/coal.png")
    glowstone_dust = extract_png(CLIENT_JAR, f"{V_ITEM}/glowstone_dust.png")
    raw_gold = extract_png(CLIENT_JAR, f"{V_ITEM}/raw_gold.png")
    iron_ingot = extract_png(CLIENT_JAR, f"{V_ITEM}/iron_ingot.png")
    flint = extract_png(CLIENT_JAR, f"{V_ITEM}/flint.png")

    total = 0

    # Calcified Amethyst: amethyst shard shifted toward calcite beige/white
    calc = remap_hsv(amethyst_shard, target_hue=50, sat_mult=0.25, val_mult=1.25, val_add=0.12)
    calc = blend_tint(calc, (225, 215, 195), strength=0.5)
    calc.save(ITEM_DIR / "calcified_amethyst.png")
    print("  calcified_amethyst.png")
    total += 1

    # Glacial Shard: amethyst shard shifted to vibrant ice blue/cyan
    glacial = remap_hsv(amethyst_shard, target_hue=195, sat_set=0.7, val_mult=1.15)
    glacial.save(ITEM_DIR / "glacial_shard.png")
    print("  glacial_shard.png")
    total += 1

    # Polished Quartz: vanilla quartz with warm-white enhancement, more distinct
    pq = remap_hsv(quartz, hue_shift=5, sat_mult=0.5, val_mult=1.15, val_add=0.08)
    pq.save(ITEM_DIR / "polished_quartz.png")
    print("  polished_quartz.png")
    total += 1

    # Polished Prismarine: prismarine shard with vivid teal, boosted saturation
    pp = remap_hsv(prismarine_shard, target_hue=168, sat_set=0.75, val_mult=1.1)
    pp.save(ITEM_DIR / "polished_prismarine.png")
    print("  polished_prismarine.png")
    total += 1

    # Ferrous Gold Ingot: gold-iron alloy blend, vibrant
    rgold = blend_tint(gold_ingot, (160, 160, 170), strength=0.4)
    rgold = remap_hsv(rgold, hue_shift=-5, sat_mult=0.9, val_mult=0.95)
    rgold.save(ITEM_DIR / "rgold.png")
    print("  rgold.png")
    total += 1

    # Raw Ferrous Gold: raw_gold with iron grey blend
    raw_rg = blend_tint(raw_gold, (160, 160, 170), strength=0.4)
    raw_rg = remap_hsv(raw_rg, hue_shift=-5, sat_mult=0.85, val_mult=0.92)
    raw_rg.save(ITEM_DIR / "raw_rgold.png")
    print("  raw_rgold.png")
    total += 1

    # Coal Dust: coal ground into dust, darker
    cd = remap_hsv(coal, target_hue=0, sat_set=0.03, val_mult=0.4)
    cd.save(ITEM_DIR / "coal_dust.png")
    print("  coal_dust.png")
    total += 1

    # Hardened Coal: coal compressed/hardened, slightly brighter than dust
    hc = remap_hsv(coal, target_hue=0, sat_set=0.05, val_mult=0.5)
    hc.save(ITEM_DIR / "hardened_coal.png")
    print("  hardened_coal.png")
    total += 1

    # Hardened Glowstone (hglow): glowstone dust but richer amber
    hg = remap_hsv(glowstone_dust, target_hue=41, sat_set=0.8, val_mult=1.1)
    hg.save(ITEM_DIR / "hglow.png")
    print("  hglow.png")
    total += 1

    # Hardened Redstone (hred): iron ingot tinted deep red
    hr = blend_tint(iron_ingot, (200, 30, 30), strength=0.6)
    hr = remap_hsv(hr, target_hue=0, sat_set=0.8, val_mult=0.8)
    hr.save(ITEM_DIR / "hred.png")
    print("  hred.png")
    total += 1

    # Ectoplasm: amethyst shard shifted to ghostly green-cyan
    ecto = remap_hsv(amethyst_shard, target_hue=160, sat_set=0.55, val_mult=1.1, val_add=0.05)
    ecto = blend_tint(ecto, (100, 240, 200), strength=0.3)
    ecto.save(ITEM_DIR / "ectoplasm.png")
    print("  ectoplasm.png")
    total += 1

    return total


def generate_hglow_emissives():
    """Generate emissive (_e) textures for hardened glowstone set.
    These are copies of the main textures with boosted brightness for shader glow.
    """
    print("\n=== HGLOW Emissive Textures ===")
    total = 0

    # Tool emissives
    for tool in TOOL_TYPES:
        src = load_local_png(ITEM_DIR / f"hglowstone_{tool}.png")
        em = remap_hsv(src, val_mult=1.3, val_add=0.15, sat_mult=1.2)
        em.save(ITEM_DIR / f"hglowstone_{tool}_e.png")
        total += 1

    # Armor item emissives
    for piece in ARMOR_PIECES:
        src = load_local_png(ITEM_DIR / f"hglow_{piece}.png")
        em = remap_hsv(src, val_mult=1.3, val_add=0.15, sat_mult=1.2)
        em.save(ITEM_DIR / f"hglow_{piece}_e.png")
        total += 1

    # Material emissive
    src = load_local_png(ITEM_DIR / "hglow.png")
    em = remap_hsv(src, val_mult=1.3, val_add=0.15, sat_mult=1.2)
    em.save(ITEM_DIR / "hglow_e.png")
    total += 1

    # Armor layer emissives
    for layer in ("1", "2"):
        src = load_local_png(ARMOR_DIR / f"hglow_layer_{layer}.png")
        em = remap_hsv(src, val_mult=1.3, val_add=0.15, sat_mult=1.2)
        em.save(ARMOR_DIR / f"hglow_layer_{layer}_e.png")
        total += 1

    print(f"  {total} emissive textures")
    return total


# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------

if __name__ == "__main__":
    if not os.path.exists(CLIENT_JAR):
        print(f"ERROR: Vanilla client jar not found at:\n  {CLIENT_JAR}")
        print("Run './gradlew build' once to download Minecraft assets.")
        exit(1)

    os.makedirs(ITEM_DIR, exist_ok=True)
    os.makedirs(ARMOR_DIR, exist_ok=True)

    total = 0
    total += generate_jagged_tools()        # 12 sets × 5 = 60 tools
    total += generate_smooth_tools()        # 10 sets × 5 = 50 tools
    total += generate_armor_items_all()     # 12 sets × 4 = 48 armor items
    total += generate_armor_layers_all()    # 12 sets × 2 = 24 armor layers
    total += generate_material_items()      # 11 material items
    total += generate_hglow_emissives()     # 12 emissive textures

    print(f"\nDone! Generated {total} textures.")
