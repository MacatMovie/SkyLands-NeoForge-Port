# Sky Lands: NeoForge 1.21.1 port

Phase 12 cloud floor adjustment, `0.26.3-port-phase12-cloudfloor`.
Original mod: DeepCanionStudio. Namespace: `flying_stuff`.
Phase 5a Fix 1 compiled and passed the user's in-game chest/launcher test.

## Build and runtime

Use a **Java 21 JDK**, then double-click `Build-One.bat`.
It uses shared Gradle from `C:\Gradle`, preferring 8.14.4 and accepting 8.13
or newer within Gradle 8. The console stays open and the JAR is copied to `dist`.
The BAT does not install a project-local Gradle distribution.

Install these alongside the new Sky Lands JAR on both client and server:

- Minecraft **1.21.1** and NeoForge **21.1.230 or newer within 21.1**.
- **TerraBlender NeoForge 1.21.1**, **4.1.0.8 or newer within 4.1**.
- **GeckoLib NeoForge 1.21.1**, **4.7.6 or newer within GeckoLib 4**.
  GeckoLib supplies the animated creatures and chests.

Use the NeoForge 1.21.1 library releases, replacing any older library versions.
The source build downloads its dependencies automatically, but does not bundle
TerraBlender or GeckoLib into Sky Lands. Keep only one Sky Lands JAR.
Player Animator **2.0.1+1.21.1 or newer within 2.x** is required on clients for
the flight poses. Dedicated servers do not need it. Cloth Config is optional;
cloud settings use NeoForge's built-in configuration screen.

GeckoLib: https://www.curseforge.com/minecraft/mc-mods/geckolib
TerraBlender: https://www.curseforge.com/minecraft/mc-mods/terrablender-neoforge

This source has **not been compiled or launched here**. Static resource,
registry, animation and API checks passed; local compilation and gameplay
are the next gate.

## Phase 12 cloud floor: Sky biome minimum Y=100

The default Sky biome cloud range is now **100–660**, lifting its lower bound
from -20 to avoid low clouds around the ground and underground. Cloud heights
still follow the same noise distribution, remapped to the chosen endpoints
(default midpoint 380, amplitude 280). Outside-biome defaults remain 190–430.
No particle rates, rendering, mob AI or gameplay behavior changes.

Existing client config files keep saved values. Open Mods → Sky Lands → Config
and change **Sky biome clouds: minimum Y** to **100** once, or reset that entry
to its new default. Existing clouds below 100 clear on the next client tick;
new clouds use the new range. The original -20 minimum remains available as a
manual setting. No fresh world is required. The following range comparison
records the original defaults before this requested adjustment.

## Phase 12 cloud range: original variation and configurable Y bounds

Comparison with the original confirms identical altitude formulas but a
behavioral difference: legacy rebuilt SimplexNoise every player tick, varying
its permutation. The first port used one fixed field, which can keep local
clouds in a narrow band. A bank of 64 noise fields is now created once and one
is randomly selected per cluster. This restores changing local heights without
per-tick noise construction, keeping cluster spacing, live-particle limits,
loaded-chunk checks, full-bright rendering and the restored island heights.
This is a bounded approximation of the original continually changing patterns;
it preserves the original formula, not its exact random sequence.

The client configuration screen adds Sky biome and outside-biome minimum and
maximum Y settings. Defaults preserve the original formulas exactly:

- Sky biomes: minimum -20, maximum 660, equivalent to `320 + noise * 340`.
- Other Overworld biomes: minimum 190, maximum 430, equivalent to
  `310 + noise * 120`.

These are the mathematical bounds for noise in [-1,1], not guaranteed occupied
heights or a uniform distribution. The original noise scale is large and the
noise value at the coordinate origin is zero for every field; near the origin,
a narrower band around Y=320/310 is also expected in the original. Particles
can render above the Y=527 build ceiling. Neither range changes island or
vanilla cloud heights. Reversed endpoints are safely swapped; equal endpoints
produce a single height. New settings are added to existing client config files
with these defaults.

After saving, clouds outside the new bounds are removed on the next client
tick. In-range existing clouds fade normally and new clouds use the new range.
To test, set the Sky biome range to 350/350, wait 5–10 seconds and check the
single layer; then try 250/450 and restore defaults. Test outside-biome settings
separately in a vanilla biome and verify they persist after a restart. A fresh
world is not needed for this cloud-only update. Near-origin height variation is
naturally limited, so also compare clouds while exploring farther away.

## Phase 12 fix: original island heights and cloud lighting

The original Forge mod extended the Overworld from min Y=-64 to an exclusive
upper bound of 528 (highest block Y=527), using height 592 and logical height
560. The early port retained the vanilla ceiling at Y=319 and lowered the
islands to fit. This fix restores the original dimension limits, all 28
changed jigsaw structure start-height distributions, and all 27 changed island
feature height ranges, including relative below-top anchors. It also restores
the original terrain-relative heightmap projection on the five affected
structures. Existing native padding and placement guards remain in place.
The Overworld noise settings are taken from exact vanilla 1.21.1, extending
only their vertical coverage to 592; the vanilla density router, terrain and
surface rules are preserved, and TerraBlender still supplies Sky biome surfaces.
The deferred extra dimensions remain deferred.

Large custom clouds now use a full-bright lightmap and no longer darken under
blocks/islands. Their original altitude formulas remain unchanged. Spawning
still uses one client listener, cached noise, at most one cluster attempt per
second, live configuration and a bounded particle list. It does not run once
per player or recreate the noise generator each tick.

Test this update in a **fresh test world**. Existing islands will not move.
Explore newly generated Sky Lands biomes around Y=300–480 and check for both
islands and clouds at their original relative heights. Check clouds passing
under islands, and use `/setblock ~ 527 ~ minecraft:stone` then remove that
block to confirm the restored ceiling. Test this command in Creative mode.
Test natural generation as well as placement commands; command coordinates
specify an explicit placement and do not test the configured natural heights.

## Phase 12: custom clouds and client settings

Restores the original five large cloud textures, original cloud heights and
slow drift in the Overworld, including all six ported Sky Lands biomes. Clouds
use stable cosmetic noise and one client tick listener, rather than creating
noise for every player every tick. Default clusters contain eight particles,
with a configurable limit of 192 live ambient particles (range 32–512).
Fade-in lasts four seconds and fade-out six seconds, across a roughly
50-second particle lifetime. Clouds are cosmetic and do not affect gameplay.
The effective spawn range is bounded by loaded chunks and render distance.

Open **Mods → Sky Lands → Config → Client → Custom Clouds**. The native
configuration screen exposes separate switches for Sky biome clouds, other
Overworld clouds and Cloud Block puffs, plus distance (64–2048), density
(0.25–2.0) and the particle limit. Changes take effect after saving without
restarting. Preferences persist in `config/flying_stuff-client.toml`.
These custom particles are independent of vanilla's Clouds setting.

For testing, visit a Sky biome and fly around Y=240–330, then wait 5–10 seconds
for clouds to fade in; their exact height varies with horizontal position.
Also check an ordinary Overworld biome. Switch each cloud category off/on
independently, lower the distance/limit, and verify the settings survive a
restart. Place several Cloud Blocks nearby and toggle their puffs; existing
puffs fade naturally. Disabling puffs does not suppress geyser effects.
Change dimensions or disconnect: ambient clouds should clear, and none
should spawn in the Nether or End. Flight and glider carry remain unchanged.

## Phase 8a Fix 1: temporary fire and launcher beam

Restores the original Temporary Fire animation metadata: 32 interpolated frames,
two ticks per frame. The PNG and fire behavior are unchanged. The launcher's
four beam planes are inset horizontally by 0.02 model units (0.00125 blocks)
on each side, removing coplanar overlap with the metal frame. Beam height, UVs,
textures, animation timing, frame geometry and launcher gameplay are unchanged.

After rebuilding, use `/setblock ~ ~ ~ flying_stuff:temporary_fire` in a
throwaway test area to check the fire animation. It expires normally. Power a
Sky Launcher and inspect the beam/frame junctions from multiple angles, also
with your normal shaders. All Phase 8a glider systems and previous fixes remain.

## Phase 8a: glider flight, stamina and canvas designs

Phase 7a passed the user's gameplay test. This batch restores the Glider,
Mechanical Geyser, all 27 canvas designs and the Lightweight I-V enchantment.
Totals: **343 item IDs**, 249 blocks, 22 entities, **212 recipes**, seven jukebox
songs and one custom enchantment. No Player Animator dependency is added.

Hold the glider in the **main hand** while airborne to glide automatically.
There is no right-click activation. Falling speed is capped at 0.04 blocks per
tick and fall distance resets while gliding; ordinary jumping ascent is retained.
Stamina starts at 6, drains 0.024 per tick, and recharges 0.05 per tick when
inactive. Exhaustion blocks reuse until stamina exceeds 5. Lightweight reduces
drain by 0.004 per level (about 12 seconds unenchanted, 72 seconds at level V).
The server owns stamina; a small owner-only update syncs movement prediction
and the action-bar percentage. No client-to-server flight-state packet exists.
Stamina belongs to the player, so swapping gliders does not replenish it.

Gliding is disabled while riding, swimming, in lava, using elytra, spectating or
Creative-flying. Native gravity is never disabled, so stopping cannot leave the
player weightless. A Mechanical Geyser directly beneath the player within four
blocks supplies bounded upward lift (0.12 blocks/tick minimum). Its cloud plume
uses the already ported particle. This replaces the original unbounded geyser
acceleration. The block has no original crafting recipe; use Creative for now.

### Crafting and customization

The original glider crafting grid (letters below) is restored:

- Top row: wool / iron ingot / wool.
- Middle row: iron ingot / leather / iron ingot.
- Bottom row: string / Celestium / string.

Craft one glider with any of the existing 27 design cards in a crafting grid.
All authored recipes now store `canvas` in the native custom-data component.
The original models, textures and card-to-design mapping are preserved. These
shapeless recipes produce a fresh glider, as the original recipes did: customize
before enchanting. Lightweight is treasure-only and non-tradeable. For this
checkpoint hold the glider and use `/enchant @s flying_stuff:lightweight 5`, or
use an enchanted book and an anvil. Ordinary enchanting-table offers do not
include Lightweight; dungeon acquisition is deferred.

### Test this checkpoint

1. In a disposable Survival test area, step off a ledge holding the glider.
   Check slow descent and stamina drain. Swap to another item to stop; fall
   damage resumes normally after stopping, so test over water first.
2. Exhaust stamina and confirm the glider stays unavailable until recharged
   beyond five points. Landing/resting refills it. Switching to a second glider
   must not reset stamina. Test Lightweight I and V for longer flights.
3. Test riding, water, elytra, Creative flight, death/respawn and reconnecting.
   Confirm normal gravity and controls after each transition.
4. Place a Mechanical Geyser and glide above it within four blocks. Check lift
   and the visible plume; leaving its column should resume ordinary gliding.
5. Apply several designs (e.g. Logo, Alpha, Creeper, Cold, Copper). Inspect the
   inventory, held glider and third-person canopy, then relog to test persistence.
   Glider designs change appearance only.
6. On a dedicated server, have two players glide independently. Check smooth
   descent, each player's own stamina, exhaustion and absence of flying kicks.

This phase uses the original held glider models and native player poses. Custom
arm/freefall animation poses and the old graphical stamina overlay remain for
polish; stamina is currently shown in the action bar. Remaining plants,
consumables, dungeon progression and the extra dimension are deferred. All
previous visual, registry-startup, trim and disc fixes are retained.

## Phase 7a: original music discs and native jukebox playback

Phase 6b Fix 2 launched and passed the user's gameplay/visual test. This batch
restores all seven original music discs, original audio and artist/title text.
They use Minecraft 1.21.1's jukebox-playable item component and data-driven song
registry. Native jukebox insertion, ejection, song display and persistence apply.
Audio streams through the Music Discs/Jukebox slider. Original tick lengths are
converted to seconds; original comparator values are preserved.

Totals: **341 item IDs**, 248 blocks, 22 entities, 184 recipes and seven jukebox
songs. Search **music** in Sky Lands Items and hover each disc to read its title.
The original mod supplied no crafting recipes for these discs. Dungeon loot
acquisition remains for a later batch; use Creative or `/give` for this gate.

| Disc title | Item ID (namespace `flying_stuff`) | Duration | Comparator |
| --- | --- | --- | --- |
| DeepCanionStudio - Cold Desert | `cold_desert_music_disc` | 83.25s | 0 |
| DeepCanionStudio - Pixel Factory | `factory_music_disk` | 84s | 13 |
| DeepCanionStudio - Sky River | `sky_river_music_disk` | 127.5s | 0 |
| DeepCanionStudio - Sky Waterfall | `sky_waterfall_music_disc` | 72.5s | 1 |
| Bomba - Ice Spike | `spike_music_disk` | 190s | 0 |
| DeepCanionStudio - Tears Of Moog City | `tears_of_moogcity` | 167s | 15 |
| DeepCanionStudio - Broken Bedrock | `underground_music_disk` | 95s | 10 |

### Test this checkpoint

1. Insert each disc in a vanilla jukebox. Confirm its title and audio, then
   eject it and confirm playback stops and the same disc returns.
2. In Survival, test insertion from both hands and confirm only one disc is
   inserted. Check the Music Discs/Jukebox volume slider.
3. Connect a comparator and verify the table's output while playing. The three
   zero-output discs intentionally preserve their original behavior.
4. Let a song finish. Test breaking an occupied jukebox and leaving/rejoining
   with a disc inserted, confirming no missing/duplicated items.
5. If testing multiplayer, have a second player listen to the same jukebox.
   Third-party jukebox mods should recognize the native component; test the
   ones in your pack before relying on their compatibility.

The glider still needs a dedicated stamina/multiplayer pass. Crops, consumables,
remaining dungeon acquisition and the extra dimension remain deferred. All
previous animation, inventory, armor-trim and startup fixes are retained.

## Phase 6b Fix 2: startup registry failure

The native trim-template constructor previously created one temporary vanilla
SmithingTemplateItem per pattern to copy its slot hints. Those six Item instances
created intrusive registry holders but were never registered, so registry freeze
stopped startup with six unregistered holders. The constructor now supplies the
localized hints and existing vanilla slot-icon resource IDs directly. Only the
six real registered templates are constructed. Original reusable crafting
behavior, all trim data and every Phase 6b Fix 1 visual correction are preserved.

Build and replace the previous Sky Lands JAR, then check startup first. If it
loads, verify template slot hints and a normal trim operation before testing
the Laser Blade animation, powered launcher beam and updated inventory icons.

## Phase 6b Fix 1: animation and inventory visuals

Restores the original texture-animation metadata for the Igneus Laser Blade
(three frames, three ticks per frame, interpolated) and powered Sky Launcher
beam (four frames, four ticks per frame, interpolated). The PNG art is unchanged.

Both launcher item icons now use the real block model with the usual angled
Minecraft GUI view. Sky Cactus log, branch and top also use that view, with
smaller scales for the wide branch/top models. Sulfur Spike's two-block-tall
item model is centered and reduced to fit its inventory slot. All four Reward
Dispenser inventory icons use 0.32 scale, exactly 80% of their former 0.4 scale.
The size adjustments affect GUI transforms only; existing explicit transforms
for other item poses are retained. Placed models, collision, power behavior and reward logic are intact.

After rebuilding, inspect the Laser Blade icon and held blade for animation.
Power a Sky Launcher with redstone and watch the moving beam. Search launcher,
cactus, sulfur and reward in Creative, then check icons in Survival inventory,
hotbar and a chest. The tall/wide models should stay within their slots. Place
each affected block to confirm its original appearance and behavior.

## Phase 6b: armor trims and trim materials

Phase 6a compiled and passed the user's gameplay test. This checkpoint restores
six original patterns: **Automaton, Dragon, Headset, Chain, Cyclops and Aracnid**,
and five materials: **Celestium, Pearlecent Celestium, Pale Celestium, Inky
Celestium and Celestine Crystal**. No new armor set or item ID is introduced.
Totals remain 334 item IDs, 248 blocks and 22 entities, now with **184 recipes**.

The six existing templates now provide native smithing slot hints. All patterns
work with vanilla trim materials and all five Sky materials. The Sky materials
also work on vanilla patterns, including the new Flow and Bolt patterns. Both
worn armor layers and inventory trim colors are restored, including dyed
leather armor overlays and the turtle helmet. The Crystal palette's original
inventory suffix mismatch is corrected. These are cosmetic trims with native
component persistence, no added combat bonuses.

### Test this checkpoint

1. Search `trim` in **Sky Lands Items** and obtain all six templates. At the
   smithing table put **template / armor / material** in the three slots.
2. Apply each Sky pattern to diamond armor with a vanilla material (e.g. gold),
   then with each of the five Sky materials. Equip a full set and inspect front,
   back and leggings in third person. Verify inventory and held item colors.
3. Use Celestium and Celestine Crystal with vanilla Sentry, Flow and Bolt
   templates. Check dyed leather armor and a turtle helmet, too.
4. Trim enchanted/damaged armor; confirm name, enchantments and damage remain.
   Relog to confirm persistence. Re-trimming with a different pattern/material
   should work; repeating an identical trim should give no output.
5. In Survival, confirm smithing consumes one template and one material.
   Check the original duplication recipes: seven diamonds around a template,
   bottom-center block as listed below. The original crafting remainder keeps
   the input template alongside the two crafted copies. Headset has no authored
   duplication recipe, so obtain its template from Creative for this gate.

| Template | Bottom-center block |
| --- | --- |
| Automaton | Cobbled Skyrock |
| Dragon | Cobbled Glaciated Skyrock |
| Chain | Lavic Skyrock |
| Cyclops | Sky Sandstone |
| Aracnid | Grimstone |

Inventory colors extend vanilla armor item models. Resource packs replacing
those item models may need matching trim overrides. Recheck an ordinary vanilla
trim and the Phase 6a swords before advancing. Gliders, crops, remaining dungeon
acquisition and the extra dimension remain deferred.

## Phase 6a: Sky equipment and infused weapons

Adds nine items and five authored smithing recipes: **334 item IDs**, 248 blocks,
22 entity types and 178 recipes. Search `Sky` and `Igneus` in **Sky Lands Items**.
The four infused swords retain their original glint, stats and short durability.
The Sky axe and shovel now use native axe/shovel behavior rather than the
original accidental pickaxe implementations. Sky mining tools have netherite
harvest capability. The war axe remains the original combat weapon.

| Item | Damage / speed | Durability | Test |
| --- | --- | --- | --- |
| Sword of the Sky | 9 / 1.65 | 3104 | Smithing upgrade; repair with Ingot of the Sky |
| Sky pickaxe, axe, shovel | 4 / 1 | 3104 | Mine stone/ore, chop and strip logs, dig and flatten dirt |
| Verdant sword | 10 / 1.65 | 169 | Hit a living target: Wither III, 10 seconds |
| Pearlecent sword | 10 / 1.65 | 169 | Frozen IV on hit; use on a block for lightning, 5s cooldown |
| Inky sword | 10 / 1.65 | 169 | Right-click: three Friendly Vex, 13s cooldown, one durability |
| Pale sword | 10 / 1.6 | 400 | Burn on hit; right-click fire wave, 1s cooldown, one durability |
| Igneus War Axe | 6.5 / 0.8 | 250 | Burn on hit and supported fire in empty space; Pale Celestium repair |

Use Survival for durability/cooldown checks and a disposable test area for fire
and lightning. Repeat abilities with both hands. Inky Vex attack monsters and
keep their existing temporary lifetime. Pale uses the tested native fire wave
without consuming the sword as ammunition; a one-second cooldown prevents spam.
War axe fire only replaces air and must survive, avoiding terrain destruction.

Smithing slots are **template / base / addition**:

- Upgrade of the Sky template / netherite sword / Ingot of the Sky -> Sky sword.
- Celestium / Sky sword / Celestium -> Verdant sword.
- Pearlecent Celestium (`amber_celestium`) / Sky sword / same -> Pearlecent sword.
- Inky Celestium / Sky sword / same -> Inky sword.
- Pale Celestium / Sky sword / same -> Pale sword.

Test with an undamaged base, then an enchanted base to confirm native component
preservation. Smithing carries damage forward too; the 169-durability infused
swords are intentionally much less durable than their base. The tools and war
axe have no original crafting recipe; obtain them from Creative for this gate.
Native sword/tool tags enable their normal enchantments. Also recheck the four
reward-dispenser inventory icons from the preceding fix.

Armor, gliders, crops, remaining dungeon acquisition and the extra dimension
are deferred. Build and test this batch before advancing.

## Phase 5b Fix 1: visible dispenser items

Phase 5b compiled and passed the user's placed-block and reward test. The four
item models inherited `builtin/entity` but had no registered item renderer,
leaving their inventory and held forms invisible. This fix registers the native
NeoForge client item extension and renders each dispenser with its existing
GeckoLib geometry and variant texture. Display instances have no world or
payment state and are cached per block type. Existing display transforms are
retained. No payment, payout, persistence, block collision or reward changes.

After rebuilding, check all four icons in **Sky Lands Blocks** (search `reward`),
then inspect each in both hands, third person, dropped on the ground and in an
item frame. Confirm variant textures, place each block, and run a normal payout.
Check version `0.9.1-port-phase5b-fix1`. Dependencies are unchanged.

## Phase 5b: reward dispensers

Phase 5a Fix 1 compiled and passed the user's in-game test. Chests, keys,
Proto Chest and launchers remain intact. This checkpoint adds all four original
reward dispensers, their GeckoLib models/textures/animations, original reward
item tags, and three linked progression advancements.

| Dispenser ID (`flying_stuff:`) | Currency ID | Reward pool |
| --- | --- | --- |
| `golden_reward_dispencer` | `celestium` | Original 7-item Golden pool |
| `glaciated_reward_dispenser` | `amber_celestium` | Original 8-item Glaciated pool |
| `lavic_reward_dispenser` | `pale_celestium` | Original 9-item Lavic pool |
| `arid_reward_dispenser` | `inky_celestium` | Original 8-item Arid pool |

The currency mapping above preserves the authored code, including Amber for
Glaciated and Pale for Lavic. Original registry spellings are retained.
Right-click with currency in either hand. Each payout costs **32 total units**,
accepting smaller deposits until full. Only the needed amount is removed from
the held stack; extra currency remains there. Payment applies in Creative too.
Empty-hand or wrong-item interaction reports the remaining cost.

A completed payment commits **2–6 random single-item rewards**, chosen uniformly
with replacement from that dispenser's original item tag. They appear in front
of the dispenser after **43 ticks (about 2.15 seconds)** at normal tick speed.
While pending, further clicks report busy and consume nothing. These are reward
item tags, preserving the original random-selection rules, rather than weighted
loot tables. Datapacks can replace the tags. An empty tag refuses payment.

Partial deposits and already selected pending rewards are saved with the block
entity. Saving/quitting or unloading the chunk resumes a pending payout without
rolling it again. Mining a machine refunds partial deposits, or releases its
committed pending rewards, as well as dropping the machine block. Each machine
has shared credit, as in the original: another player can complete a deposit.
Hoppers do not access the payment escrow; deposits are made by hand. These
blocks have their authored two-block-tall shape and do not occupy an upper
block cell automatically. Leave headroom when placing them.

The original `sky_lands`, `into_the_sky`, and `gambling` advancements are ported
with current icon and biome-predicate formats. `into_the_sky` retains its original
requirement to visit all six biomes. `gambling` is awarded when a payout is
committed, so leaving during the animation does not lose advancement credit.
Animations use synchronized GeckoLib triggers, with no client world edits.

Totals: **248 blocks, 325 item IDs, 22 entity types and 173 recipes**. There are
two native block entity types and two native chest menu types. The dispensers
are available in the Blocks tab; authored dungeon placement remains pending.
No substitute crafting or progression recipes are added.

## Local Phase 5b test gate

1. Build with `Build-One.bat`, replace the previous JAR, and confirm version
   `0.9.1-port-phase5b-fix1`. Dependencies are unchanged. Start with a clean test
   instance using the same TerraBlender and GeckoLib versions as Phase 5a.
2. Place all four machines facing different directions, with headroom. Check
   their textures, 3D inventory models, idle animation and collision shape.
3. For each machine, use the currency in the table. Try a wrong currency first;
   none should be consumed. Give 64 correct currency, click once and confirm
   32 remain. Wait about 2.15 seconds and check that 2–6 rewards appear in front.
4. Test small deposits such as 10, 10 and 20. The last deposit should consume
   only 12, leaving 8. Check the remaining-cost message between deposits.
   Test a correct off-hand stack with an empty/unrelated main hand.
5. Spam-click during a payout: nothing extra should be charged while busy.
   Repeat payouts and confirm insertion/payout animations restart properly.
6. Deposit 10, save/quit/reopen, and confirm the machine still needs 22. Complete
   a payment and save/quit quickly before the payout; reopening should release
   the same committed rewards once. Also test chunk unload/reload if practical.
7. Break a partially paid machine: its block and exactly the deposited currency
   should drop. Break during a pending payout: the block and committed rewards
   should drop, with no later extra payout. Test Survival mining and explosions.
8. Check the restored advancement tab and reward advancement. On multiplayer,
   test shared deposits and completing payment before disconnecting. Check
   insertion/payout animations from both clients, and verify server startup.
9. Recheck chest unlocking, Proto Chest item persistence, launcher power changes,
   a few mobs and new island chunks. Run `/reload` and inspect `logs/latest.log`
   for missing tags, models, advancement predicates or block entity errors.

This checkpoint has not been compiled or launched here. Send build output if
compilation fails, or `logs/latest.log` plus a crash report for runtime failures.

## Phase 5a Fix 1

Fixes the eight reported compilation errors by adding the missing `ModItems`
import in `SkyChestKind`. All eight existing key registrations are verified.
This fix compiled and passed the user's local test. The Phase 5a test checklist
below is retained for regression checks.

## Phase 5a: chests and redstone launchers

Phase 4b Fix 1 compiled and passed the user's in-game mob test. Its fire API,
entity dimensions, spawn predicates and synchronized mob animation fixes remain.
Small block/item issues reported during that test await specific repro steps.

This checkpoint adds **19 blocks and their item IDs**: eight locked/unlocked
chest pairs, Proto Chest, and two launcher states. Totals: **244 blocks,
321 item IDs, 22 entity types and 173 recipes**. One native block entity type
supports all 17 chest blocks; two native menu types preserve their capacities.

| Locked chest ID (`flying_stuff:`) | Required key ID | Slots |
| --- | --- | --- |
| `golden_sky_level_1_chest` | `goldenlevel_1_key` | 27 |
| `golden_sky_level_2_chest` | `golden_level_2_key` | 27 |
| `glaciated_sky_level_1_chest` | `diamond_level_1_key` | 27 |
| `glaciated_sky_level_2_chest` | `diamond_level_2key` | 27 |
| `lavic_sky_lvl_1_chest` | `lavic_level_1_key` | 27 |
| `lavic_sky_lvl_2_chest` | `lavic_level_2_key` | 27 |
| `arid_sky_level_0_chest` | `arid_level_1_key` | 27 |
| `arid_sky_level_2_chest` | `arid_level_2_key` | 27 |
| `proto_chest` (already unlocked) | None | 44 |

Each family has its authored `open_` block variant. Right-click a locked chest
with the matching key in either hand. Survival consumes one key after successful
unlock; Creative does not consume it. Wrong keys leave the block and stack
unchanged. Unlock preserves facing, stored items, custom names, native loot-table
settings and item components, then opens the inventory. The Master Key had no
implemented legacy unlock behavior and is not given substitute functionality.

Locked chests retain their authored unbreakability. Unlocked chests and Proto
Chest can be mined with a stone-tier or better pickaxe. Breaking an unlocked
chest spills contents once and drops its block. No double-chest merging is added.
Hoppers can insert/extract from unlocked chests and Proto Chest; locked chests
expose no automation slots. Comparators reflect unlocked inventory fullness.
Save/load uses Minecraft 1.21.1 registry-aware item serialization.

Original GeckoLib geometry, per-family textures, open/close animations, sound
assets, flat inventory icons and GUI textures are retained. The animation state
is managed by server menu openers, including multiple players and disconnects;
client rendering no longer edits world blocks. Proto Chest preserves all 44
slots, including the two side columns, rather than rounding to a vanilla size.

`sky_launcher` and `active_sky_launcher` switch with redstone, retaining facing.
Jump from the pad to use the authored jump factors: 3 unpowered, 23 powered.
They are six pixels high and apply Minecraft's native jump behavior. Landing on
a pad does not automatically launch you. The active state drops the ordinary
launcher when mined, and either item reconciles to actual power when placed.

These blocks are testable from Creative. Newly placed chests start empty.
At the Phase 5a checkpoint, dungeon/arena placement, authored reward loot,
reward dispensers, gliders, armor progression and the extra dimension were pending; Phase 5a did not
invent acquisition recipes or populate chests with substitute rewards.

## Phase 4b scope

This batch includes **all 16 original mob types**, all six original combat
projectile types, nine GeckoLib animated models, 16 spawn eggs, three effects
and six combat/death particle types. Authored mob stats, models, textures,
animations, attacks, sounds, immunities and existing loot tables are retained.

The three tested Phase 4a melee automatons and Automaton Sword remain active.
Phase 4b totals were **225 block types, 302 item IDs, 22 entity types and 173 recipes**.
The extra block is temporary fire, which has no inventory item.

| Mob ID (`flying_stuff:` prefix) | Behavior to test |
| --- | --- |
| `sky_automaton` | Golden sword melee, potion immunity, drops |
| `arid_sky_automaton` | Unarmed melee and arid drops |
| `lavic_sky_automaton` | Sword melee and fire immunity |
| `sky_automaton_boss` | Dual-sword melee boss |
| `automaton_drone` | Hovering movement and levitation shots |
| `glaciated_sky_automaton` | Ice-bow ranged attacks and freezing |
| `glaciated_dragon` | Flying pursuit, ice bombs and death burst |
| `sky_automaton_brute` | Animated melee brute |
| `ice_blob` | Animated melee and crystallized-ice drop |
| `magma_slobert` | Animated melee and fire immunity |
| `igneo_robo_feline` | Fire-wave shots and contact attack |
| `sky_bird` | Ground movement, panic and raw wing drop |
| `sky_pharaoh` | Melee and occasional husk summoning |
| `friendly_vex` | Flying ally attacks and authored short lifespan |
| `happy_slobert` | Taming, owner assistance, following and breeding |
| `artificial_aracnid` | Animated melee and glowing texture layer |

Natural spawning is restored where the authored biomes are already active:
Sky Birds spawn in Golden Flying Islands above Y=169; Happy Sloberts spawn in
Floating Swamp above Y=200. Original weights/group sizes are retained.
Artificial Aracnids' natural spawn biomes belong to the deferred dimension.
Other mobs retain the original disabled natural-spawn setting.
Use eggs or `/summon` to test them. Structure encounters still await the
corresponding dungeons/arenas; the tested island templates contain no entities.

## Combat items and effects

- **Ice Bow:** hold/release to shoot, using ordinary arrows outside Creative;
  128 durability, authored fixed shot power. Ice arrows apply Frozen and
  Slowness II for two seconds.
- **Igneus Laser Blade:** seven total melee damage, 1.6 attack speed,
  400 durability, five seconds of burning on melee hits. Right-click fires a
  wave with a one-second cooldown and costs durability. It does not consume
  the blade itself as ammunition, unlike the broken legacy ammo path.
- **Smoke Flower:** right-click throws one flower with a three-second cooldown.
  Ground impact creates the authored smoke and short Hidden-effect clouds.
- **Float Grape:** right-click throws one grape with a 2.5-second cooldown.
  Direct hits and ground impacts apply the authored levitation effects.
- **Eye of the Sky:** right-click throws its zero-damage cosmetic projectile.
  Its old zero-speed/nonfunctional item-use path is repaired. This does not
  activate a dimension portal or structure-finding feature.
- **Automaton Sword:** Phase 4a durability, poison, gold repair and recipe kept.

Frozen uses native frozen ticks and snowflakes. Warmth prevents freezing while
active. Hidden suppresses mob targeting, preserving the authored Warden
exception. It no longer creates teams, removes players from existing teams,
or leaves scoreboard membership behind after expiration.

The pharaoh summons husks through entity APIs rather than permission-level
commands. Procedure animations use GeckoLib's synchronized triggers.
Temporary fire places only into empty supported cells and expires after three
seconds through scheduled ticks. The legacy offsets could overwrite the floor;
this behavior is corrected. Native death processing handles XP/removal once.

The projectile items are available in the Items tab. Additional survival
acquisition through unported crops, chests or progression remains pending;
new substitute recipes are not invented for this checkpoint.

## Retained worldgen

The six tested Overworld biomes, TerraBlender weight/replacement map, scoped
surface rules, 60 configured/placed features, 60 templates, six structures and
seven pools are retained unchanged. Two new biome modifiers add the authored
creature spawns. Standard Overworld height (-64 through 319) remains in use.
Main floating features occupy approximately Y=160-270. Supported Arid large
islands start at Y=160-210; Swamp clusters start at Y=160-180.

## Local Phase 5a test gate

1. Run `Build-One.bat`, replace the old Sky Lands JAR and keep the same required
   TerraBlender/GeckoLib versions. Confirm `0.9.1-port-phase5b-fix1` in the mod list.
2. In Creative, place Proto Chest and every locked chest on different facings.
   Check textures and original inventory icons. Test wrong keys first, then
   matching keys in Survival with a stack: exactly one should be consumed.
   Also test a key in the off hand with an empty or unrelated main hand.
3. Use shift-click both ways; fill all 27 family slots and all 44 Proto slots,
   especially Proto's side columns. Store named/enchanted items, save/quit and
   reopen the world. Contents, item components and facing should remain.
4. Test transfer through an actual locked chest, not only empty chests. Place
   a Golden level 1 chest, then run this command while aiming coordinates at it:
   `/data merge block X Y Z {Items:[{Slot:0b,id:"minecraft:diamond",count:7}]}`.
   Unlock it with a Golden level 1 key and confirm all seven diamonds remain.
   A hopper must not pull them before unlock. Save/reload the unlocked chest.
5. Test hoppers above/below unlocked chests and Proto Chest. Check a comparator
   with empty, partially filled and full inventories. Break a stocked unlocked
   chest with the correct pickaxe: contents and block should drop once.
6. Open/close each family and Proto Chest. Check sounds and lid animation. On a
   multiplayer test, two players should keep a lid open until both close their
   menus; walking away or disconnecting should close it after the last opener.
7. Place launchers facing different directions. Jump from them without power,
   then power with a lever/redstone and repeat. Use Creative or a safe landing
   area for the high jump. Remove power, place an active launcher without power,
   and mine a powered launcher to check state changes and the ordinary drop.
8. Recheck a few tested mobs and explore new island chunks. Run `/reload` and
   check `logs/latest.log` for menu, block entity, texture, loot or tag errors.
   A dedicated-server test with both dependencies is especially useful now.

Send compile output for a build failure; for runtime failures send
`logs/latest.log` and any crash report. This source checkpoint has not been
compiled or launched here; the local build/gameplay test is the next gate.

## Remaining work

The extra dimension, its entrances and its related structure graphs remain deferred. The independent Overworld structure batches have passed the user's tests. Remaining work is a parity review and gameplay polish, optional configuration integration, and broader modpack and dedicated-server checks. This checkpoint does not declare the entire port complete.

`legacy/forge-1.20.1` preserves the original uploaded workspace unchanged,
outside active Gradle source/resource sets and excluded from the mod JAR.
The optional `-PportLibraries=true` profile stages Cloth Config. Player Animator is now active independently of that profile; leave the profile disabled for this test.


## Phase 8b: plants and Warmth consumables

Adds the mature Smoke Flower plant, Float Grape plant, Warmth Radish plant, Warmth Radish, and Warmth Potion. The Smoke Flower's two existing growth variants now support harvesting and natural regrowth. Right-click either half of a mature plant to collect one throwable Smoke Flower. Both halves become the immature variant together. The lower half has the authored 40% chance to regrow on each random tick. The original growth-stage class never wired its procedure into random ticks; this port makes that intended behavior functional.

Warmth Radish gives Warmth II for 2 seconds and restores 1 hunger point. Warmth Potion gives Warmth II for 50 seconds, uses the drinking animation, and returns one glass bottle in Survival. A stacked potion adds the bottle to inventory or drops it if full. Creative does not consume potions or produce bottles. Both can be used at full hunger. Warmth clears freezing while active.

Float Grape plants drop one throwable Float Grape, and Warmth Radish plants drop one radish, following the original loot tables. This batch does not add new world generation or acquisition recipes; use Creative for testing these newly restored plants and consumables.

### Phase 8b test

- Place a Smoke Flower plant on grass or supported island soil. Right-click its upper and lower halves in separate harvests; verify one Smoke Flower per harvest and an intact two-block immature plant.
- Wait for regrowth. In a disposable test world, `/gamerule randomTickSpeed 100` speeds up testing; restore it to 3 afterwards. Existing immature plants should also regrow. Breaking either half should remove the full plant without duplicate drops.
- Break Float Grape and Warmth Radish plants in Survival and check their drops.
- Eat a radish at full hunger, then drink a potion and check Warmth duration. Test a single potion, a stack, full inventory, and Creative bottle behavior.
- Check multiplayer harvesting if available. The previous glider and visual fixes remain included.

Source and asset checks are performed here. Build and runtime testing are performed locally using Build-One.bat.


## Phase 9a: Golden, Cherry, and Arid dungeons

Restores three naturally generating structures: Golden Floating Dungeon, Cherry Floating Dungeon, and Arid Sky Temple. Includes 20 original NBT pieces, five jigsaw pools, three structure sets, embedded guards, eight spawners, and eleven locked chests. The authored pool weights, horizontal generation spacing, block geometry, chest contents, and guard equipment are preserved.

The original structures started above Y=340 in the taller Sky Lands dimension. This Overworld port uses start heights Y=160-205 for Golden/Cherry and Y=165-210 for Arid, with an eight-block dimension boundary padding. They generate in their matching existing Sky Lands biomes in newly generated chunks. Existing chunks will not gain dungeons automatically.

NBT migration explicitly updates old grass IDs, modern item counts/components, and custom chest block-entity IDs. Embedded mobs use the currently registered native attributes instead of obsolete Forge attributes and saved random attribute modifiers. Original relative mob positions, equipment, health, and spawner parameters remain. Chests retain their lazy LootTable assignments across unlocking and saving.

Restores the original Golden level-one and Arid level-one loot tables, including materials, glider designs, music discs, and Lightweight I/II enchanted books. No weights or reward counts are rebalanced here. The ice dungeon and lava tower await their Storm Block/fluid dependencies; other large structures remain for later batches. The two guard loot tables also use explicit native number providers for reliable key drops. No Java source changes are required in this batch.

### Phase 9a test

Use a new disposable Creative world or unexplored chunks for natural generation tests.

- Locate the biome first with `/locate biome flying_stuff:flying_islands`, `flying_stuff:floating_cherry_grove`, or `flying_stuff:arid_floating_islands`, then explore nearby new chunks. `/locate structure flying_stuff:golden_floating_dungeon`, `flying_stuff:cherry_floating_dungeon`, and `flying_stuff:arid_sky_temple` locate generated starts.
- For a quick assembly test in an empty area, use `/place structure flying_stuff:golden_floating_dungeon ~ 180 ~` (and the other two IDs). Inspect room connections, intact chest models, guards, and spawners. Switch briefly to Survival to test hostile AI/spawning.
- Give yourself a Golden Level 1 Key or Arid Level 1 Key. Unlock a generated chest, check its rewards, then save/reload and confirm it does not refill. Wrong keys should leave it locked.
- `/loot give @s loot flying_stuff:chests/goldenskychests` and `/loot give @s loot flying_stuff:blocks/arid_skytable` test each restored reward table directly. Repeat to check random rewards and Lightweight books; apply a book to a glider in an anvil.
- Check ordinary existing island world generation, plants, glider flight, and previous animation fixes remain functional.

Build using Build-One.bat locally. Source/data validation here does not replace in-game world generation and loot tests.


## Phase 9b: Glaciated Sky Dungeon and Storm Blocks

Restores the Glaciated Sky Dungeon in the existing Glaciated Floating Islands biome. It has six original room/corridor templates, one jigsaw pool, two spawner templates, four embedded guards, and a locked chest template. Structure spacing, piece weights, geometry, relative guard positions, equipment, and chest rewards are preserved. Starts are moved to Y=160-205 with eight blocks of dimension padding for the Overworld.

Adds Storm Block and Deactivated Storm Block. The active block refreshes Frozen II for 150 ticks in the authored 12x12x12 area centered at its block coordinates, once per 10 server ticks. A 30% chance per pulse plays the original large storm-cloud particle and mechanism/wind sounds. This avoids the original repeated scans from client animation, collisions, and neighbor callbacks. Scheduled ticks persist across saving and unloading. A small block entity starts the loop when a chunk loads, including for naturally generated blocks. Inactive blocks do no scheduled work.

Use a Glaciated level-one key (registry ID diamond_level_1_key) in either hand to permanently deactivate a Storm Block. Survival consumes one key; Creative does not consume it. Existing Frozen effects and clouds can linger until their normal expiry after deactivation. Wrong keys do not disable the trap. Both block variants preserve their original full light and unbreakable Survival behavior. Warmth Radish/Potion protect against Frozen through the existing Warmth effect.

Restores the original Glaciated level-one chest loot, including glider designs, music discs, materials, and Lightweight enchanted books. The Glaciated Automaton key-drop table also uses native number providers. Chest NBT IDs and equipment components are migrated as in Phase 9a. The lava tower still awaits the molten-metal fluid port. All earlier phases and fixes remain included.

### Phase 9b test

- In an empty area of a disposable world: `/place structure flying_stuff:glaciated_sky_dungeon ~ 180 ~`. For natural generation, explore new chunks in the Glaciated Floating Islands biome, or `/locate structure flying_stuff:glaciated_sky_dungeon` nearby.
- Inspect room connections, spawners, guards, and locked chests. Unlock a generated chest with a Glaciated level-one key, check its rewards, and save/reload to confirm it stays unlocked without refilling.
- `/loot give @s loot flying_stuff:glaciated_sky_chestlvl_1` checks the restored reward table directly.
- Place a Storm Block and approach it in Survival: check Frozen II, clouds, and sounds. Drink Warmth Potion while nearby to check protection. Step beyond its field to let Frozen expire.
- Give yourself `/give @s flying_stuff:diamond_level_1_key`. Try a wrong key, then deactivate with the correct key in the main hand and offhand on separate blocks. Verify one-key consumption in Survival, no consumption in Creative, and no new effects after deactivation.
- Save/reload near an active Storm Block, then unload/revisit its chunk. Verify its field resumes. Test on multiplayer if available.

Compile locally using Build-One.bat; source/data checks here do not replace runtime testing.


## Phase 9c Fix 1: Lavic Tower placement crash with Lithium

Both reported crashes occur during fluid ticks after the tower has placed, in
Lithium 0.15.4's `calculateComplexFluidFlowDirections`. Molten metal's original
slope-search distance of eight selects a 190-entry cache, but Lithium accesses
part of that cache using a signed byte. Indices above 127 become negative.

Molten metal now uses the standard water-sized slope-search distance of four,
whose 66-entry cache keeps every index nonnegative. This changes how far it
looks ahead for downhill paths. Tick delay, fluid level decay, contact damage,
textures, bucket behavior, structure geometry and all other content remain.
No Lithium dependency, global optimization toggle, or world-data conversion is
added. Existing molten metal uses the new setting when it ticks.

Build using `Build-One.bat`, replace the previous Sky Lands JAR, and keep
Lithium enabled. In a disposable world, retry `/place structure
flying_stuff:lavic_tower ~ 180 ~` and `/place structure
flying_stuff:lavic_tower ~ 100 ~` at separate empty sites. Wait near each tower
for at least a minute so its molten metal can spread, then save/reload and
revisit. Also test the Molten Metal Bucket on a broad flat floor with a
containing wall, where fluid can search in several directions. Static source,
resource and signed-index regression checks passed here; compilation and
modpack gameplay testing remain local.

## Phase 9c: molten metal and Lavic Tower

Fixes Storm Block freezing fields to exclude Creative and Spectator players. Survival/Adventure players and living mobs remain affected. An already applied Frozen effect expires normally after switching modes; the field does not refresh it in exempt modes.

Adds molten-metal source/flowing fluids, their luminous animated rendering, and the Molten Metal Bucket. Preserves the original eight-tick flow delay, slope-search distance four (reduced from eight for Lithium compatibility in Fix 1), motion scale 0.0035, light level 15, density/viscosity/temperature, and 15-second ignition on contact. The fluid does not allow swimming or drowning, and does not form infinite sources. The fluid block has no inventory item; use the bucket. Textures and frame metadata come directly from the original mod, and the bucket uses NeoForge's native fluid-container model. Common/server code contains no client rendering classes.

Restores Lavic Tower generation in Lavic Floating Islands, with original templates, jigsaw connections, spawners, guards, locked chests, and molten-metal channels. Starts use Y=160-205 and eight-block dimension padding. Piece weights, horizontal spacing, geometry, and reward weights remain unchanged. NBT chest IDs/equipment use the same migration as previous dungeon batches. Restores the original Lavic level-one chest loot and normalizes Lavic Automaton key drops.

### Phase 9c test

- Test Storm Blocks in Survival and Adventure, then Creative and Spectator. Only the first two player modes should receive new Frozen effects. Wait for any pre-existing effect to expire after changing mode.
- Place molten metal using its bucket in a contained test area. Check still/flowing animation, emitted light, spreading, source pickup with an empty bucket, and the bucket's inventory image. In Survival, contact should ignite you; Fire Resistance should still protect normally. Save/reload and check fluid persistence. Test with shaders separately if used.
- `/place structure flying_stuff:lavic_tower ~ 180 ~` assembles the dungeon in an empty disposable test area. Inspect joins, molten-metal channels, guards, and spawners.
- For natural generation, explore new chunks in Lavic Floating Islands or `/locate structure flying_stuff:lavic_tower` nearby.
- Unlock a generated chest with its Lavic level-one key, check rewards, and save/reload to check it does not refill. `/loot give @s loot flying_stuff:chests/lavic_lvl_1_chest` tests rewards directly.
- All previous dungeon, glider, plant, visual, and equipment features remain included. Compile locally using Build-One.bat; runtime testing remains required.


## Phase 9d: floating towers and Glaciated Sky Castle

Restores Golden Floating Tower, Cherry Floating Tower, and Glaciated Sky Castle
in their matching Sky Lands Overworld biomes. Adds 15 original room templates,
six jigsaw pools, and three structure sets. The templates contain seven
spawners, three locked chest placements, four Ice Blobs, and one equipped
Glaciated Sky Automaton. Counts describe the templates; actual assemblies
randomly repeat or omit pieces. The castles use their original interconnected
towers, walkways, and ice/water channels.

Golden/Cherry towers start at Y=220-255 and build downward. Castle starts use
Y=160-190. Eight-block dimension padding constrains accepted pieces to the
Overworld. Original horizontal spacing, separation, room geometry, spawner
parameters, equipment and reward tables are preserved. The Golden tower pool's
reference to `isle_tower_dungeon_3` is removed because that file is absent from
the original source; its three supplied rooms retain equal weights. Cherry
connectors now have explicit matching top/bottom names instead of blank
`minecraft:` identifiers. Their orientations, positions and room weights stay
unchanged. Entity attributes, item components and chest IDs receive the same
1.21.1 migration as the previously tested dungeon batches.

No new item/block IDs are added. Towers use the existing Golden level-one key
and chest rewards; the castle uses Diamond level-one keys and Glaciated rewards.
Existing chunks do not gain structures automatically. All previous features,
Creative/Spectator freezing-field exemption, and the molten-metal Lithium fix
remain included. Extra-dimension content is still deferred.

### Phase 9d test

In separate empty sites in a disposable world:

- `/place structure flying_stuff:floating_tower ~ 230 ~`
- `/place structure flying_stuff:floating_cherry_tower ~ 230 ~`
- `/place structure flying_stuff:glaciated_sky_castle ~ 180 ~`

Check the towers' stacked rooms and top chamber, castle joins/waterways,
spawners and guards. Assemblies vary, so try several
placements if a particular room or water-channel branch is absent. Unlock
Golden tower chests with `/give @s flying_stuff:goldenlevel_1_key` and castle
chests with `/give @s flying_stuff:diamond_level_1_key`. Check rewards, then
save/reload to ensure chests stay unlocked and do not refill.

For natural generation, use `/locate structure` with the same IDs in newly
generated chunks of Flying Islands, Floating Cherry Grove or Glaciated Floating
Islands respectively. Keep Lithium enabled and briefly recheck Lavic Tower
placement. Build with `Build-One.bat`; static resource, dependency, connector
and preservation checks here do not replace local compilation/gameplay tests.


## Phase 9e: four archipelagos and Lavic canopy

Restores Golden, Glaciated, Arid and Lavic Archipelago structures: connected
clusters of small islands and branching links. Includes 28 original templates,
eight pools and four structure sets. Each variant's center template contains
its corresponding existing Reward Dispenser. Their saved block-entity IDs are
migrated to the native reward-dispenser type and captured animation states are
reset to idle. Empty legacy inventories become fresh deposits/payout state.
Room geometry, connector positions, pool weights, spacing and reward pools stay
unchanged. No embedded guards or spawners occur in these templates.

Starts use Y=160-225 with eight-block boundary padding. Golden also generates
above its original plains, forest, beach and ocean biomes; Glaciated above
snowy plains/frozen ocean; Arid above desert; all four also use their matching
Sky Lands biome. Only new chunks can generate them naturally. The Arid pool's
missing `glaciated_arcipelago/empty` template reference is repaired with a
native empty-pool element, keeping weight four and terminating that branch.
This prevents an invalid cross-variant reference from breaking assembly.

Adds Lavic Fungus Block and Lavic Tree Sapling, bringing totals to 257 blocks
and 353 items. The fungus restores original texture, strength, emission,
light-blocking and visual shape, using native leaf distance/decay. Original
sapling/stick canopy drops are normalized for 1.21.1. The sapling uses the
already-tested native Sky Sapling growth/bonemeal system and island-soil
support. It grows a branching acacia-style Lavic stem/fungus tree; this is a
native growth replacement for the legacy procedure that pasted a fixed tree
NBT over surrounding blocks. The existing natural tree features stay unchanged.
No new Java API or runtime dependency is introduced. All earlier content and
the molten-metal Lithium fix remain included; the extra dimension stays deferred.

### Phase 9e test

At separate empty sites in a disposable world:

- `/place structure flying_stuff:golden_archipelago ~ 180 ~`
- `/place structure flying_stuff:glaciated_archipelago ~ 180 ~`
- `/place structure flying_stuff:arid_archipelago ~ 180 ~`
- `/place structure flying_stuff:lavic_archipelago ~ 180 ~`

Check island links and the dispensers in the main islands. Assemblies vary;
repeat a placement if it has few branches. Pay 32 Celestium to Golden,
32 Amber Celestium to Glaciated, 32 Inky Celestium to Arid or 32 Pale Celestium
to Lavic. Check insertion/payout animation and rewards. Test a partial deposit,
save/reload, and complete the remaining payment to confirm it persists.

Give yourself `/give @s flying_stuff:lavic_tree_sapling`. Plant on ordinary dirt
or supported Lavic island soil, leave open space, and use bone meal repeatedly
to grow it. Check Lavic stems and luminous fungus canopy, canopy drops, decay
when stems are removed, and the two new inventory models. Existing natural
Lavic tree generation has not been changed in this batch.

Use `/locate structure` with those IDs in newly generated matching biomes for
natural generation tests. Build with `Build-One.bat`; static API/resource,
NBT migration and preservation checks do not replace local compilation and
in-game/modpack testing. Keep Lithium enabled during testing.


## Phase 9f: five Great Sky Islands

Restores Golden, Cherry, Glaciated, Swampy and Lavic Great Sky Islands in their
matching Sky Lands biomes. Includes 60 original templates, ten jigsaw pools
and five structure sets. Golden includes its small and large island layouts;
other variants retain their original connected terrain pieces and link shapes.
Four locked chest placements occur in the Golden/Glaciated template sets,
using existing level-one keys and reward tables. Assemblies randomly select
and repeat pieces, so actual chest counts and overall shapes vary. These
pieces do not contain authored guards or spawners.

Starts use Y=160-205 with eight-block dimension padding for the Overworld.
Original block geometry, connector orientations/positions, surviving piece
weights, horizontal spacing, separation and salts are preserved. The Golden
big-piece pool entry for `gsi_big/chunk3` is removed because that NBT is absent
from the source. One Glaciated edge connector's missing `gsiice_ncd` pool is
corrected to `gsiice_nc`, which contains its matching line piece. One Lavic
connector is corrected from the invalid `minecraft:lavic_great_sky_island` pool
to `flying_stuff:lavic_great_sky_island`. Thirteen
loose bamboo/petal item entities captured in a Cherry template are removed as
authoring debris; plant blocks remain unchanged. Grass names and chest IDs
receive the same native 1.21.1 migration as the previously tested batches.

No new items, blocks, Java behavior or loot tables are added. All earlier
features and fixes remain included, including the four archipelagos, Lavic
canopy/sapling and molten-metal Lithium compatibility. The extra dimension
continues to be deferred. Natural generation requires newly generated chunks.

### Phase 9f test

At separate empty sites in a disposable world:

- `/place structure flying_stuff:great_sky_island ~ 180 ~`
- `/place structure flying_stuff:great_sky_island_cherry ~ 180 ~`
- `/place structure flying_stuff:glaciated_great_sky_island ~ 180 ~`
- `/place structure flying_stuff:swampy_great_sky_island ~ 180 ~`
- `/place structure flying_stuff:lavic_great_sky_island ~ 180 ~`

Inspect connected terrain, ice/swamp links, vegetation and template joins.
Golden can select different small/big starting layouts; repeat placements to
see that variety. Golden chests use `/give @s flying_stuff:goldenlevel_1_key`;
Glaciated chests use `/give @s flying_stuff:diamond_level_1_key`. Check rewards
and save/reload to confirm unlocked chests stay unlocked without refilling.

For natural generation, use `/locate structure` with the same IDs in newly
generated Flying Islands, Floating Cherry Grove, Glaciated Floating Islands,
Floating Swamp and Lavic Floating Islands respectively. Build with
`Build-One.bat`; source/resource checks do not replace local compilation and
modpack gameplay testing. Keep Lithium enabled and retain the earlier tests.


## Phase 9g: four boss arenas and level-two rewards

Restores Golden, Arid, Glaciated and Lavic boss arenas in their matching
Overworld Sky Lands biomes. Four original templates, four pools and four
structure sets retain their geometry, spacing, separation and salts. Starts
use absolute Y=160-205 with eight-block dimension padding; the legacy heightmap
projection is removed so terrain elevation is not added to the floating height.

Each arena contains one persistent boss and one locked level-two chest:
Sky Automaton Boss, Sky Pharaoh, Glaciated Dragon and Igneo Robo Feline,
respectively. Saved legacy Forge attributes/UUIDs are removed so native
registered attributes and fresh entity identities are used. Automaton swords
use native item components. The dragon starts at its registered 150 HP
instead of its captured legacy 210 HP. Existing boss combat Java is unchanged.

Restores all four original level-two chest reward tables, including Celestium
cores, trim templates, glider designs, weapons and the Golden Lightweight IV
book. Random pool selection means some individual rewards are alternatives.
The Lavic reward table uses the chest loot context while retaining its original
ID. All four boss loot tables use native number providers/functions and retain
one guaranteed matching level-two key. Chests use the tested native block
entity and existing key/unlock/save logic. Also ports the two previously missing staff reward items with their original
models/textures: Ice Staff (100 durability, ice-bomb shot on release, one
crystallized ice per Survival shot, 50-tick cooldown) and Pharaoh Staff
(350 durability, three friendly vexes per use, 260-tick cooldown). Server-only
spawning/ammo/durability handling avoids duplicate client effects.

### Phase 9g test

Place at separate empty locations in a disposable world:

- `/place structure flying_stuff:skyarena ~ 180 ~`
- `/place structure flying_stuff:skyarenadesert ~ 180 ~`
- `/place structure flying_stuff:skyarenaice ~ 180 ~`
- `/place structure flying_stuff:skyarenalavic ~ 180 ~`

Check one boss and a locked chest per arena. Fight in Survival with difficulty
Easy/Normal/Hard, collect the matching key and unlock the chest. Verify reward
items (and the Golden Lightweight IV book), then save/rejoin to check boss
persistence and that opened chests remain unlocked without regenerating loot.
For a quick chest-only test, give the respective key:
`golden_level_2_key`, `arid_level_2_key`, `diamond_level_2key`,
`lavic_level_2_key`, all under `flying_stuff`.

Use `/locate structure` with these IDs in newly generated matching biomes to
check natural generation. Keep Lithium enabled for the molten-metal Lavic
arena. Build using `Build-One.bat`; this checkpoint was checked as source and
resources only, and has not been compiled/launched here. Earlier phases and
fixes remain included. Extra-dimension work remains deferred.

Staff test: give `flying_stuff:ice_staff` and `flying_stuff:cristalizedice`,
hold/release use and verify one projectile/ammo/durability change per shot.
Try without ammo and in Creative. Give `flying_stuff:pharaoh_staff`, right-click
and check exactly three friendly vexes, durability and the 13-second cooldown.


## Phase 9h: island clusters, Lavic railway/spike and bird island

Restores five additional Overworld structures with 27 original templates,
seven pools (including the Glaciated end-cap fallback) and five structure sets:
Golden Island Cluster, Glaciated Island Cluster, Lavic Railway, Huge Lavic
Spike and the large Golden bird island (`fil_0`). Their authored geometry,
connector orientations/positions, piece weights, horizontal spacing and
separation are preserved. Glaciated pieces reach 132 blocks tall; their starts
use absolute Y=100-155, leaving room above for the island tops and ice links.
Golden clusters, railway and bird island start at Y=160-205. The huge spike
keeps its original Y=141-159 trapezoid start and vertical stacking. All five
use eight-block Overworld dimension padding. Bird-island heightmap projection
is removed so terrain height is not added to the floating height.

The two legacy cluster salts exceed Minecraft's nonnegative 32-bit integer
range; their low 31 bits are retained as valid salts (Golden 626518623,
Glaciated 636518623). Existing spacing and separation stay unchanged. The
start-pool name for `lava_spike_start` is corrected to match its registry ID.
Structure save-marker blocks use vanilla single-pool-element filtering.

Railway pieces include stations, curves, junctions, slopes and two static
train-car layouts. They are decorative structures, with no moving-train
mechanic. Authored train-car placements contain one equipped Lavic Automaton,
two Magma Sloberts and one locked Lavic level-one chest across the two car
templates. A random railway assembly can repeat or omit those pieces.
The bird island contains three Sky Birds and one Golden level-one chest.
Legacy entity UUIDs/Forge attributes are removed and the Automaton's sword
uses native item components. Chest IDs use the tested native Sky Chest block
entity with existing lazy loot tables. Earlier boss arenas/staffs and all
other fixes remain included. No new items, Java code or loot tables.

### Phase 9h test

Use separate empty locations in a disposable world:

- `/place structure flying_stuff:golden_island_cluster ~ 180 ~`
- `/place structure flying_stuff:glaciated_island_cluster ~ 120 ~`
- `/place structure flying_stuff:lavic_railway ~ 180 ~`
- `/place structure flying_stuff:lavic_huge_spike ~ 150 ~`
- `/place structure flying_stuff:fil_0 ~ 180 ~`

Inspect joined island terrain/ice strings, railway joins and train cars, and
the huge spike's stacked sections. Repeat random railway/cluster placements
to see different layouts. Check birds on `fil_0` and mobs in train cars;
railways do not guarantee both train-car pieces on every placement.
Unlock the railway chest with `flying_stuff:lavic_level_1_key` and bird-island
chest with `flying_stuff:goldenlevel_1_key`. Check rewards and save/rejoin to
confirm unlocked chests retain their contents without regenerating loot.

Use `/locate structure` with these IDs in newly generated matching Flying
Islands, Glaciated Floating Islands and Lavic Floating Islands biomes to
check natural generation. Keep Lithium enabled during molten-metal tests.
Build with `Build-One.bat`; source/NBT/resource checks are complete, but this
checkpoint has not been compiled or launched here. Floating village professions
and trades are the next planned step. Extra-dimension work remains deferred.


## Phase 9i: remaining independent Overworld structures and village system

Completes both remaining structures that do not require the deferred extra
dimension: Floating Village and the ruined surface portal. Includes ten
original templates, four pools and two structure sets. Village roads, slopes,
end caps, farms, houses and center retain their geometry, weights, spacing,
separation and salt. The missing `golden_village/road_curved` pool reference is
corrected to the existing `golden_village/road_curve` template, keeping weight 3.
Village starts use absolute Y=160-205 and eight-block dimension padding. The
ruined portal retains its original surface-heightmap projection, geometry,
spacing and salt; it is an abandoned frame with no dimension travel mechanic.

Ports the Celestium Anvil workstation, its original model/icon/drop/tool tags,
and the `flying_stuff:cool` villager profession and POI. NeoForge's POI registry
callback maps all four facing states, and the native acquirable-job-site tag
allows unemployed villagers to claim it. The original profession texture and
three trades are restored:

- Novice: 10 Celestium for one Cloud Block (10 uses, 5 villager XP).
- Novice: two Emeralds plus eight Celestium for one Island Glider Design
  (10 uses, 9 villager XP).
- Apprentice: one Golden Level 1 Key plus one Celestium Block for one Headset
  Armor Trim Smithing Template (10 uses, 11 villager XP).

All retain the original 0.05 price multiplier. The workstation serves this
profession; it did not provide a vanilla anvil repair menu in the original.
Saved villager offers use native count fields and omit invalid air/zero-count
second costs. Absolute author-world job/home memories and restock timestamps
are reset so placed villagers can claim local workstations and restock in the
new world's time. Authored professions, levels, XP, prices and rewards remain.
Templates contain seven Cool Villagers, one Farmer and one Golden Sky painting
in total; random village assemblies can repeat/omit housing and farm pieces.

Restores all three original paintings using native data-driven painting
variants and the placeable tag: Golden Sky (1x2), Mod Logo Painting (2x2) and
Glaciated Sky Painting (2x1), with original textures and title/author text.
Existing structures, bosses, staff items and earlier fixes remain included.

### Phase 9i test

At separate empty locations:

- `/place structure flying_stuff:floating_village ~ 180 ~`
- `/place structure flying_stuff:portal ~ ~ ~`

Use a disposable world. The portal command follows the local terrain height.
Check village joins, curved roads, houses/farms, villagers, workstation models
and the painting in a medium house when that piece is selected. Repeat the
village command at another site to check random layouts. Use `/locate structure`
with both IDs in newly generated Flying Islands biomes for natural generation.

Give yourself `flying_stuff:celestium`, Emeralds, `flying_stuff:goldenlevel_1_key`
and `flying_stuff:celestium_block`. Test both novice trades, level a Cool
Villager to Apprentice and test the Headset trim trade. Exhaust a trade, allow
villagers a normal daytime work period near reachable anvils, and check
restocking. Trade once, save/rejoin and check profession/offers/XP persist.
Place a Celestium Anvil beside an unemployed adult villager in daylight to
verify profession acquisition. Check all four facing directions, the inventory
icon and stone-pickaxe-or-better drop. Use a vanilla painting item on appropriately
sized walls to test all three new variants; placement is random.

Build with `Build-One.bat`. Source/API/resource checks do not replace local
compilation and in-game/modpack tests; this version has not been compiled here.
No independent Overworld structures remain to port after this checkpoint.
The five remaining legacy structures are deferred together with their required
extra-dimension subsystem: Abyssal Root, Abyssal City, Roof Scraper, Underground
Lighthouse and the active Underground Portal Entrance. Their original source
is retained in `legacy/forge-1.20.1`.


## Phase 10: Starter Guide and Overworld progression cleanup

Phase 9i passed the user's test. This batch restores the Sky Lands Starter Guide with its original cover and item artwork. Right-click it in either hand to open seven instruction pages; the arrow buttons navigate and Escape closes the guide. The original blank second page now explains the ported gameplay. No inventory slots or extra page-change packets are involved. It is available in Creative; no new acquisition recipe is invented.

Restores five original advancements: Old Man's Gift (obtain a Glider) and the Golden, Glaciated, Arid and Lavic victories (obtain their regional cores). Their original parent links, criteria, titles and descriptions are preserved. Into the Sky now completes on any one of the six Sky Lands biomes, matching its description, rather than requiring all six.

Adds seven original building recipes: each of the three Sky Cactus log/branch/top blocks makes four Inky Planks; Fiery Leaves make the two mossy Skyrock variants, and Glaciated Leaves make the two mossy Glaciated Skyrock variants. The Magma Slobert loot table now uses native namespaced count functions and uniform number providers, preserving the original drops and probabilities.

### Phase 10 test

1. Build with Build-One.bat, replace the previous JAR, and launch with the existing dependencies. This source checkpoint has not been compiled or launched here.
2. Get the guide from Creative or `/give @s flying_stuff:sky_lands_starter_guide`. Open it in both hands, read all seven pages, go back to the cover, close/reopen, and try another GUI scale. Check that its inventory icon is visible.
3. Craft planks from each Sky Cactus variant and try the four mossy building recipes above. Check counts and output variants in the crafting grid or recipe viewer.
4. Obtain a Glider and the four regional cores with inventory space available; check the new advancements. Visit one Sky Lands biome to test Into the Sky. Previously completed advancements need not trigger a second toast. Use a fresh player or revoke the relevant advancement if retesting.
5. Kill several Magma Sloberts to check normal loot handling; individual drops remain random. If possible, also open the guide on a dedicated server.

Send compiler output for build failures, or latest.log and the crash report for runtime failures.


## Phase 11: Freefall controls and graphical flight HUD

Phase 10 passed the user's gameplay test. Restores the original Freefall control (R by default, rebindable in Options > Controls > Movement). Stow the Glider and press the key while airborne to toggle freefall; hold the sneak key for the fast dive. Press the key again to stop. Equipping a main-hand Glider cancels freefall and resumes the existing gliding rules. Freefall cannot start on the ground, in liquids, while riding, during Elytra flight, while using Creative flight or in Spectator mode. Landing or entering those states clears it; death, dimension changes and reconnecting reset the toggle.

The client sends a toggle request; the server validates eligibility and rate-limits requests. Movement is predicted for the local player using the synced state. Ordinary descent follows the original -1.1 vertical target, and fast dive uses the original -4.5 target. Native gravity stays enabled, so the exact effective speeds can differ slightly from the legacy no-gravity implementation. Fall damage remains enabled. Original speed particles and the normal/fast freefall audio are restored; sound starts immediately and is spaced four seconds apart on the server, avoiding overlapping clips and duplicate client/server playback. The external player pose animation integration is still deferred.

Restores the Glider stamina overlay using the original five icons and background artwork. The meter appears during gliding and recharge, with the existing percentage/recharge text above it. This replaces the Glider's repeated action-bar messages. Freefall shows its current mode nearby. The HUD hides with F1, in Spectator and while a screen is open. The Starter Guide gains an eighth page for Freefall.

### Phase 11 test

1. Build with Build-One.bat and replace the previous mod JAR. No new dependency is required. This source checkpoint has not been compiled or launched here.
2. At a safe height, test in Survival/Adventure: stow the Glider, press R, hold/release sneak to compare dive speeds, then press R again to stop. Check the Freefall label, speed particles and both sounds. Use water or equip a Glider before landing, since freefall does not prevent fall damage.
3. Try R while grounded, swimming, riding, using Elytra, in Creative flight and in Spectator; it should not activate. Check that landing, equipping a Glider and entering water stop the mode. Rebind R in Controls if it conflicts with another mod.
4. Glide until the stamina meter empties, then let it refill. Check its five icons, percentage, recharge label, F1 hiding and different GUI scales. Existing Lightweight/design recipes and Glider movement should still work.
5. Check the guide's new page. If possible, test with two players on a server, including reconnecting, respawning and changing dimension while freefall was active; verify normal movement resumes and another player's controls do not toggle your mode.

Send compiler output for a failed build, or latest.log and the crash report for a runtime failure.


## Phase 11 flight fixes

Restores the original normal Freefall, fast Freefall, Glider and return-to-standing animations using Player Animator 2.x. Original animation JSON is preserved byte-for-byte under the modern player_animations folder. Flight poses synchronize to the owner and tracking players, including those who begin tracking mid-flight. The animation layer clears when entering water, riding, Creative flight, Spectator or Elytra flight; normal stopping uses the original return animation.

**New client requirement:** install Player Animator for NeoForge 1.21.1, version 2.0.1+1.21.1 or newer within 2.x. The mod JAR does not bundle it. It is not required on dedicated servers. TerraBlender and GeckoLib requirements remain as before.

Normal Freefall's vertical limit is reduced from 1.1 to 0.9 blocks per tick (about 18% slower). Fast Freefall is reduced from 4.5 to 1.65 (about 63% slower), with gradual acceleration instead of the immediate jump to dive speed. Native gravity remains enabled, so effective speeds vary slightly. Fall damage still applies.

The graphical Glider stamina meter remains; numeric percentage and recharge text are removed. The Freefall/Fast Freefall mode label remains.

### Flight-fix test

Compile with Build-One.bat, install the new client dependency, and replace the previous Sky Lands JAR. Test R/Shift above water, compare descent speeds, and use F5 to check both Freefall poses. Equip the Glider to check its pose, then land or toggle off to check the return animation. Verify water, riding, Creative flight and Elytra restore the appropriate vanilla pose. Check that the stamina meter has no text counter. If possible, check the poses with a second player. No compilation or game launch has been performed here.


## Glider grounded third-person carry fix

The selected Glider now uses a separate carry transform while the player is grounded. In third person it sits upright beside the hand at 70% scale, rather than using the overhead gliding transform on a normal walking arm. The left-hand view is mirrored by Minecraft. All 28 canvas variants retain their textures.

Only thirdperson_righthand and thirdperson_lefthand transforms are changed for grounded models. First-person, inventory, dropped-item and frame transforms inherit the existing values. Airborne players use the original models and gliding poses. No movement, stamina or player-animation behavior changes.

Test with F5 while standing and walking, then jump/glide to check that the overhead airborne model returns. Compare first person on the ground and in flight, check a few canvas designs, and switch main-hand preference to left in Skin Customization. If possible, have another player watch. Build with Build-One.bat as usual; Player Animator remains required on clients. No compilation or game launch has been performed here.
