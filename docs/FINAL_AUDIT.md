# Final v0.9.0 audit

Baseline: 0.26.3-port-phase12-cloudfloor, tested by the user in singleplayer,
on a dedicated server, with shaders and other mods.

## Findings resolved in this release

- Restored high-altitude wind streaks, Fiery Leaves particles and Swampy Bush
  fireflies with their original artwork. Wind spawns once per client with the
  original >195 height rule and ~two streaks per second, using the existing
  random source. A native client toggle is provided for wind visuals.
- Restored the original base Sky Sword return when Verdant, Pearlecent, Inky
  or Pale infusion breaks, preserving enchantments. Server-only recovery is
  delivered after vanilla finishes clearing the broken slot; occupied hands
  fall back to inventory or a dropped item. Logout flushes pending recovery.
- Restored all 26 omitted feature definitions referenced by original biome
  modifiers for the six active Sky biomes and original vanilla biome targets, with original placements and
  rarity settings. Includes small island variants, rare vanilla-biome islands, launcher platforms, the
  Golden launcher/landing arrangement, a large ice spike and molten-metal
  delta patches. Native template height/write guards remain active.
- The original large ice spike was stored as a Sponge schematic instead of a
  vanilla template. Its palette and varint block array are converted to a
  native structure template. The Golden launcher's authored pieces are merged
  at offsets 0/50/180, avoiding delayed cross-chunk marker-block writes.
- Converted legacy chest item counts in the restored islands and one already
  active cherry island. Corrected an unregistered detailed_cloud_block palette
  entry to the registered Cloud Block. Chest loot references remain intact.
- Updated metadata to SkyLands - Unofficial Port, version 0.9.0, and the exact
  requested JAR filename. Retained mod ID flying_stuff and original credit.

## Checked scope and remaining exclusions

The active registries contain 258 original blocks and all 22 original entity
IDs. All 101 original standalone item IDs except the deferred dimension item
are present. Original block item generation is retained. All 65 original
feature references in modifiers for the six Sky biomes now resolve. The 34
ported jigsaw structures and their existing graphs remain in place. Active
recipe, particle, template and custom model-parent references were checked.

Deferred with the dimension: its biomes/ores, entry blocks and Abyssal doors,
related generator utilities, five structure graphs and discovery advancement.
Twelve old wood boat/sign recipes reference item IDs never registered by the
original mod; they are broken leftovers, not working content to restore.
The Aracnid trim recipe is present under its corrected spelling, and the
copied Automaton trim recipe is a redundant duplicate of the existing recipe.
Unreferenced legacy feature files are not treated as active worldgen content.

This is a scoped source/resource audit, not a claim of byte-identical behavior
or exhaustive runtime testing of every interaction. Earlier checkpoints retain
intentional native API fixes and bounded particle/scan behavior. The build
height is Y=-64..527, and the default Sky cloud interval remains 100..660.

## Verification and final gate

Static checks passed for 2,456 active JSON files, all 263 active native NBT
structure templates, custom palette IDs, item counts, original active Sky biome
feature references, particle sprite resources, model parents and release names.
NeoForge 21.1.230 source was inspected for the item-break event API; unlike the
legacy attempted cancellation, this event is non-cancellable, hence delayed
recovery. Client-only rendering stays isolated from common/server classes.

No Gradle build or game launch was performed here. Before publishing, compile
v0.9.0 locally and run the short README checks for the restored island variants,
launchers, cosmetic particles and sword recovery, including a dedicated server
smoke test. The unfinished dimension remains a later project.
