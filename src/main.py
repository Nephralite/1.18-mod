# Aim: to automate the million copy, paste, find and replace calls with a more modular function system
# this time, about half the size and minus like 300 ish repitions
# now with added PEP compliance (bar the blockstates which are like 4000 characters for some)
# note: stores textures in blocks and items with an s, if you don't you'd need to change it in the classes under .models
import os
import json

from builtins import super, len

modid = 'myfirstmod'
# change this to your mods directory which probably looks like '~/Documents/ExampleMod/src/main/resources'
project_root = '/home/jade/Documents/1.18-mod/src/main/resources'
os.makedirs(project_root, exist_ok=True)
os.chdir(project_root)  # makes sure we are working in the right place for the first write


# FILE MANIPULATION
def make_file(directory, name, contents, mode='w'):  # use mode='a' for lang #tested
    os.makedirs(directory, exist_ok=True)  # makes path if not present
    os.chdir(directory)
    with open(name, mode) as f:
        f.write(contents)       # writes to file
    os.chdir(project_root)  # return back to root


def jsonize(x):
    #  print(x)
    return json.dumps(json.loads(x), indent=2)  # dumb indent formatting


# ASSETS
# shortcut definitions
assets = f"assets/{modid}"


def append_lang(contents, lang="en_us.json"):  # needs rewrite, needs to insert before bracket and remove trailing comma
    make_file(f"{assets}/lang", lang, contents, mode='a')


def model(parent, textures): 
    output = '{' + f'"parent":"{parent}"'  # bracket in fstring caused highlighting issues
    if textures != {}:
        output += ',"textures":{'
        for key, val in textures.items():
            output += f"{key}:{val},"
        output = output[:-1] + '}'  # removes trailing comma and closes brackets
    output += '}'
    return output


def block_item(name): 
    return jsonize(model(f"{modid}:block/{name}", {})), name


class Block:  # basic single texture block
    def __init__(self, name):
        self.name = name
        self.item = block_item(name)
        self.default_model = f'model": "{modid}:block/{name}'
        self.blockstate = f'{{"variants": {{"": {{ "{self.default_model}" }}}}}}'
        self.models = {"": model("block/cube_all", {'"all"': f'"{modid}:blocks/{name}"'})}


class Slab(Block):  # half of a base block with same name minus _slab
    def __init__(self, name):
        super().__init__(name)  # slightly inefficient but meh
        self.blockstate = f'{{"variants": {{"type=bottom": {{"{self.default_model}"}},"type=double": {{"model": "{modid}:block/{name[:-5]}"}},"type=top": {{"{self.default_model}_top"}}}}}}'  # name[:-5] is name without _slab
        texture = f'"{modid}:blocks/{name[:-5]}"'
        wrapped_texture = {'"bottom"': texture, '"top"': texture, '"side"': texture}
        self.models[""] = model("minecraft:block/slab", wrapped_texture)
        self.models["_top"] = model("minecraft:block/slab_top", wrapped_texture)


class Stair(Block):  # three quarter block with texture copied like slab
    def __init__(self, name):
        super().__init__(name)
        self.blockstate = f'{{"variants": {{"facing=east,half=bottom,shape=inner_left": {{"{self.default_model}_inner","y": 270,"uvlock": true}},"facing=east,half=bottom,shape=inner_right": {{"{self.default_model}_inner"}},"facing=east,half=bottom,shape=outer_left": {{"{self.default_model}_outer","y": 270,"uvlock": true}},"facing=east,half=bottom,shape=outer_right": {{"{self.default_model}_outer"}},"facing=east,half=bottom,shape=straight": {{"{self.default_model}"}},"facing=east,half=top,shape=inner_left": {{"{self.default_model}_inner","x": 180,"uvlock": true}},"facing=east,half=top,shape=inner_right": {{"{self.default_model}_inner","x": 180,"y": 90,"uvlock": true}},"facing=east,half=top,shape=outer_left": {{"{self.default_model}_outer","x": 180,"uvlock": true}},"facing=east,half=top,shape=outer_right": {{"{self.default_model}_outer","x": 180,"y": 90,"uvlock": true}},"facing=east,half=top,shape=straight": {{"{self.default_model}","x": 180,"uvlock": true}},"facing=north,half=bottom,shape=inner_left": {{"{self.default_model}_inner","y": 180,"uvlock": true}},"facing=north,half=bottom,shape=inner_right": {{"{self.default_model}_inner","y": 270,"uvlock": true}},"facing=north,half=bottom,shape=outer_left": {{"{self.default_model}_outer","y": 180,"uvlock": true}},"facing=north,half=bottom,shape=outer_right": {{"{self.default_model}_outer","y": 270,"uvlock": true}},"facing=north,half=bottom,shape=straight": {{"{self.default_model}","y": 270,"uvlock": true}},"facing=north,half=top,shape=inner_left": {{"{self.default_model}_inner","x": 180,"y": 270,"uvlock": true}},"facing=north,half=top,shape=inner_right": {{"{self.default_model}_inner","x": 180,"uvlock": true}},"facing=north,half=top,shape=outer_left": {{"{self.default_model}_outer","x": 180,"y": 270,"uvlock": true}},"facing=north,half=top,shape=outer_right": {{"{self.default_model}_outer","x": 180,"uvlock": true}},"facing=north,half=top,shape=straight": {{"{self.default_model}","x": 180,"y": 270,"uvlock": true}},"facing=south,half=bottom,shape=inner_left": {{"{self.default_model}_inner"}},"facing=south,half=bottom,shape=inner_right": {{"{self.default_model}_inner","y": 90,"uvlock": true}},"facing=south,half=bottom,shape=outer_left": {{"{self.default_model}_outer"}},"facing=south,half=bottom,shape=outer_right": {{"{self.default_model}_outer","y": 90,"uvlock": true}},"facing=south,half=bottom,shape=straight": {{"{self.default_model}","y": 90,"uvlock": true}},"facing=south,half=top,shape=inner_left": {{"{self.default_model}_inner","x": 180,"y": 90,"uvlock": true}},"facing=south,half=top,shape=inner_right": {{"{self.default_model}_inner","x": 180,"y": 180,"uvlock": true}},"facing=south,half=top,shape=outer_left": {{"{self.default_model}_outer","x": 180,"y": 90,"uvlock": true}},"facing=south,half=top,shape=outer_right": {{"{self.default_model}_outer","x": 180,"y": 180,"uvlock": true}},"facing=south,half=top,shape=straight": {{"{self.default_model}","x": 180,"y": 90,"uvlock": true}},"facing=west,half=bottom,shape=inner_left": {{"{self.default_model}_inner","y": 90,"uvlock": true}},"facing=west,half=bottom,shape=inner_right": {{"{self.default_model}_inner","y": 180,"uvlock": true}},"facing=west,half=bottom,shape=outer_left": {{"{self.default_model}_outer","y": 90,"uvlock": true}},"facing=west,half=bottom,shape=outer_right": {{"{self.default_model}_outer","y": 180,"uvlock": true}},"facing=west,half=bottom,shape=straight": {{"{self.default_model}","y": 180,"uvlock": true}},"facing=west,half=top,shape=inner_left": {{"{self.default_model}_inner","x": 180,"y": 180,"uvlock": true}},"facing=west,half=top,shape=inner_right": {{"{self.default_model}_inner","x": 180,"y": 270,"uvlock": true}},"facing=west,half=top,shape=outer_left": {{"{self.default_model}_outer","x": 180,"y": 180,"uvlock": true}},"facing=west,half=top,shape=outer_right": {{"{self.default_model}_outer","x": 180,"y": 270,"uvlock": true}},"facing=west,half=top,shape=straight": {{"{self.default_model}","x": 180,"y": 180,"uvlock": true}}}}}}'  # this is a 200 line json, this as much of a shortened version without smart for loops that you'll get
        texture = f'"{modid}:blocks/{name[:-7]}"'
        wrapped_texture = {'"bottom"': texture, '"top"': texture, '"side"': texture}
        self.models[""] = model("minecraft:block/stairs", wrapped_texture)
        self.models["_inner"] = model("minecraft:block/stairs_inner", wrapped_texture)
        self.models["_outer"] = model("minecraft:block/stairs_outer", wrapped_texture)


def inventory_item(name):
    return jsonize(model(f"{modid}:block/{name}_inventory", {})), name


class Button(Block):  # takes texture from name minus _button, so name accordingly or change it after
    def __init__(self, name):
        super().__init__(name)
        self.item = inventory_item(name)
        self.blockstate = f'{{"variants": {{"face=ceiling,facing=east,powered=false": {{"{self.default_model}","y": 270,"x": 180}},"face=ceiling,facing=east,powered=true": {{"{self.default_model}_pressed","y": 270,"x": 180}},"face=ceiling,facing=north,powered=false": {{"{self.default_model}","y": 180,"x": 180}},"face=ceiling,facing=north,powered=true": {{"{self.default_model}_pressed","y": 180,"x": 180}},"face=ceiling,facing=south,powered=false": {{"{self.default_model}","x": 180}},"face=ceiling,facing=south,powered=true": {{"{self.default_model}_pressed","x": 180}},"face=ceiling,facing=west,powered=false": {{"{self.default_model}","y": 90,"x": 180}},"face=ceiling,facing=west,powered=true": {{"{self.default_model}_pressed","y": 90,"x": 180}},"face=floor,facing=east,powered=false": {{"{self.default_model}","y": 90}},"face=floor,facing=east,powered=true": {{"{self.default_model}_pressed","y": 90}},"face=floor,facing=north,powered=false": {{"{self.default_model}"}},"face=floor,facing=north,powered=true": {{"{self.default_model}_pressed"}},"face=floor,facing=south,powered=false": {{"{self.default_model}","y": 180}},"face=floor,facing=south,powered=true": {{"{self.default_model}_pressed","y": 180}},"face=floor,facing=west,powered=false": {{"{self.default_model}","y": 270}},"face=floor,facing=west,powered=true": {{"{self.default_model}_pressed","y": 270}},"face=wall,facing=east,powered=false": {{"{self.default_model}","y": 90,"x": 90,"uvlock": true}},"face=wall,facing=east,powered=true": {{"{self.default_model}_pressed","y": 90,"x": 90,"uvlock": true}},"face=wall,facing=north,powered=false": {{"{self.default_model}","x": 90,"uvlock": true}},"face=wall,facing=north,powered=true": {{"{self.default_model}_pressed","x": 90,"uvlock": true}},"face=wall,facing=south,powered=false": {{"{self.default_model}","y": 180,"x": 90,"uvlock": true}},"face=wall,facing=south,powered=true": {{"{self.default_model}_pressed","y": 180,"x": 90,"uvlock": true}},"face=wall,facing=west,powered=false": {{"{self.default_model}","y": 270,"x": 90,"uvlock": true}},"face=wall,facing=west,powered=true": {{"{self.default_model}_pressed","y": 270,"x": 90,"uvlock": true}}}}}}'
        wrapped_texture = {'"texture"': f'"{modid}:blocks/{name[:-7]}"'}
        self.models[""] = model("minecraft:block/button", wrapped_texture)
        self.models["_pressed"] = model("minecraft:block/button_pressed", wrapped_texture)
        self.models["_inventory"] = model("minecraft:block/button_inventory", wrapped_texture)


class Fence(Block):  # same note as button, generates bad jsons for names like "acacia_fence"
    def __init__(self, name):
        super().__init__(name)
        self.item = inventory_item(name)
        self.blockstate = f'{{"multipart": [{{"apply": {{"{self.default_model}_post"}}}},{{"when": {{"north": "true"}},"apply": {{"{self.default_model}_side","uvlock": true}}}},{{"when": {{"east": "true"}},"apply": {{"{self.default_model}_side","y": 90,"uvlock": true}}}},{{"when": {{"south": "true"}},"apply": {{"{self.default_model}_side","y": 180,"uvlock": true}}}},{{"when": {{"west": "true"}},"apply": {{"{self.default_model}_side","y": 270,"uvlock": true}}}}]}}'
        wrapped_texture = {'"texture"': f'"{modid}:blocks/{name[:-6]}"'}
        del self.models[""]
        self.models["_inventory"] = model("minecraft:block/fence_inventory", wrapped_texture)
        self.models["_post"] = model("minecraft:block/fence_post", wrapped_texture)
        self.models["_side"] = model("minecraft:block/fence_side", wrapped_texture)


class FenceGate(Block):
    def __init__(self, name):
        super().__init__(name)
        self.blockstate = f'{{"variants": {{"facing=east,in_wall=false,open=false": {{"uvlock": true,"y": 270,"{self.default_model}"}},"facing=east,in_wall=false,open=true": {{"uvlock": true,"y": 270,"{self.default_model}_open"}},"facing=east,in_wall=true,open=false": {{"uvlock": true,"y": 270,"{self.default_model}_wall"}},"facing=east,in_wall=true,open=true": {{"uvlock": true,"y": 270,"{self.default_model}_wall_open"}},"facing=north,in_wall=false,open=false": {{"uvlock": true,"y": 180,"{self.default_model}"}},"facing=north,in_wall=false,open=true": {{"uvlock": true,"y": 180,"{self.default_model}_open"}},"facing=north,in_wall=true,open=false": {{"uvlock": true,"y": 180,"{self.default_model}_wall"}},"facing=north,in_wall=true,open=true": {{"uvlock": true,"y": 180,"{self.default_model}_wall_open"}},"facing=south,in_wall=false,open=false": {{"uvlock": true,"{self.default_model}"}},"facing=south,in_wall=false,open=true": {{"uvlock": true,"{self.default_model}_open"}},"facing=south,in_wall=true,open=false": {{"uvlock": true,"{self.default_model}_wall"}},"facing=south,in_wall=true,open=true": {{"uvlock": true,"{self.default_model}_wall_open"}},"facing=west,in_wall=false,open=false": {{"uvlock": true,"y": 90,"{self.default_model}"}},"facing=west,in_wall=false,open=true": {{"uvlock": true,"y": 90,"{self.default_model}_open"}},"facing=west,in_wall=true,open=false": {{"uvlock": true,"y": 90,"{self.default_model}_wall"}},"facing=west,in_wall=true,open=true": {{"uvlock": true,"y": 90,"{self.default_model}_wall_open"}}}}}}'
        wrapped_texture = {'"texture"': f'"{modid}:blocks/{name[:-11]}"'}
        self.models[""] = model("minecraft:block/template_fence_gate", wrapped_texture)
        self.models["_open"] = model("minecraft:block/template_fence_gate_open", wrapped_texture)
        self.models["_wall"] = model("minecraft:block/template_fence_gate_wall", wrapped_texture)
        self.models["_wall_open"] = model("minecraft:block/template_fence_gate_wall_open", wrapped_texture)


class Plate(Block):
    def __init__(self, name):
        super().__init__(name)
        self.blockstate = f'{{"variants": {{"powered=false": {{"{self.default_model}"}},"powered=true": {{"{self.default_model}_down"}}}}}}'
        wrapped_texture = {'"texture"': f'"{modid}:blocks/{name[:-15]}_planks"'}
        self.models[""] = model("minecraft:block/pressure_plate_up", wrapped_texture)
        self.models["_down"] = model("minecraft:block/pressure_plate_down", wrapped_texture)


class Door(Block):
    def __init__(self, name):
        super().__init__(name)
        self.item = custom_item(name)
        self.blockstate = f'{{  "variants": {{"facing=east,half=lower,hinge=left,open=false": {{"{self.default_model}_bottom"}},"facing=east,half=lower,hinge=left,open=true": {{"{self.default_model}_bottom_hinge","y": 90}},"facing=east,half=lower,hinge=right,open=false": {{"{self.default_model}_bottom_hinge"}},"facing=east,half=lower,hinge=right,open=true": {{"{self.default_model}_bottom","y": 270}},"facing=east,half=upper,hinge=left,open=false": {{"{self.default_model}_top"}},"facing=east,half=upper,hinge=left,open=true": {{"{self.default_model}_top_hinge","y": 90}},"facing=east,half=upper,hinge=right,open=false": {{"{self.default_model}_top_hinge"}},"facing=east,half=upper,hinge=right,open=true": {{"{self.default_model}_top","y": 270}},"facing=north,half=lower,hinge=left,open=false": {{"{self.default_model}_bottom","y": 270}},"facing=north,half=lower,hinge=left,open=true": {{"{self.default_model}_bottom_hinge"}},"facing=north,half=lower,hinge=right,open=false": {{"{self.default_model}_bottom_hinge","y": 270}},"facing=north,half=lower,hinge=right,open=true": {{"{self.default_model}_bottom","y": 180}},"facing=north,half=upper,hinge=left,open=false": {{"{self.default_model}_top","y": 270}},"facing=north,half=upper,hinge=left,open=true": {{"{self.default_model}_top_hinge"}},"facing=north,half=upper,hinge=right,open=false": {{"{self.default_model}_top_hinge","y": 270}},"facing=north,half=upper,hinge=right,open=true": {{"{self.default_model}_top","y": 180}},"facing=south,half=lower,hinge=left,open=false": {{"{self.default_model}_bottom","y": 90}},"facing=south,half=lower,hinge=left,open=true": {{"{self.default_model}_bottom_hinge","y": 180}},"facing=south,half=lower,hinge=right,open=false": {{"{self.default_model}_bottom_hinge","y": 90}},"facing=south,half=lower,hinge=right,open=true": {{"{self.default_model}_bottom"}},"facing=south,half=upper,hinge=left,open=false": {{"{self.default_model}_top","y": 90}},"facing=south,half=upper,hinge=left,open=true": {{"{self.default_model}_top_hinge","y": 180}},"facing=south,half=upper,hinge=right,open=false": {{"{self.default_model}_top_hinge","y": 90}},"facing=south,half=upper,hinge=right,open=true": {{"{self.default_model}_top"}},"facing=west,half=lower,hinge=left,open=false": {{"{self.default_model}_bottom","y": 180}},"facing=west,half=lower,hinge=left,open=true": {{"{self.default_model}_bottom_hinge","y": 270}},"facing=west,half=lower,hinge=right,open=false": {{"{self.default_model}_bottom_hinge","y": 180}},"facing=west,half=lower,hinge=right,open=true": {{"{self.default_model}_bottom","y": 90}},"facing=west,half=upper,hinge=left,open=false": {{"{self.default_model}_top","y": 180}},"facing=west,half=upper,hinge=left,open=true": {{"{self.default_model}_top_hinge","y": 270}},"facing=west,half=upper,hinge=right,open=false": {{"{self.default_model}_top_hinge","y": 180}},"facing=west,half=upper,hinge=right,open=true": {{"{self.default_model}_top","y": 90}}}}}}'
        wrapped_texture = {'"top"': f'"{modid}:blocks/{name}_top"', '"bottom"': f'"{modid}:blocks/{name}_bottom"'}
        del self.models[""]
        self.models["_bottom"] = model("minecraft:block/door_bottom", wrapped_texture)
        self.models["_top"] = model("minecraft:block/door_top", wrapped_texture)
        self.models["_bottom_hinge"] = model("minecraft:block/door_bottom_rh", wrapped_texture)
        self.models["_top_hinge"] = model("minecraft:block/door_top_rh", wrapped_texture)


class Trapdoor(Block):
    def __init__(self, name):
        super().__init__(name)
        self.item = block_item(f"{name}_bottom")
        self.blockstate = f'{{"variants": {{"facing=east,half=bottom,open=false": {{"{self.default_model}_bottom","y": 90}},"facing=east,half=bottom,open=true": {{"{self.default_model}_open","y": 90}},"facing=east,half=top,open=false": {{"{self.default_model}_top","y": 90}},"facing=east,half=top,open=true": {{"{self.default_model}_open","x": 180,"y": 270}},"facing=north,half=bottom,open=false": {{"{self.default_model}_bottom"}},"facing=north,half=bottom,open=true": {{"{self.default_model}_open"}},"facing=north,half=top,open=false": {{"{self.default_model}_top"}},"facing=north,half=top,open=true": {{"{self.default_model}_open","x": 180,"y": 180}},"facing=south,half=bottom,open=false": {{"{self.default_model}_bottom","y": 180}},"facing=south,half=bottom,open=true": {{"{self.default_model}_open","y": 180}},"facing=south,half=top,open=false": {{"{self.default_model}_top","y": 180}},"facing=south,half=top,open=true": {{"{self.default_model}_open","x": 180,"y": 0}},"facing=west,half=bottom,open=false": {{"{self.default_model}_bottom","y": 270}},"facing=west,half=bottom,open=true": {{"{self.default_model}_open","y": 270}},"facing=west,half=top,open=false": {{"{self.default_model}_top","y": 270}},"facing=west,half=top,open=true": {{"{self.default_model}_open","x": 180,"y": 90}}}}}}'
        wrapped_texture = {'"texture"': f'"{modid}:blocks/{name}"'}
        del self.models[""]
        self.models["_bottom"] = model("minecraft:block/template_orientable_trapdoor_bottom", wrapped_texture)
        self.models["_top"] = model("minecraft:block/template_orientable_trapdoor_top", wrapped_texture)
        self.models["_open"] = model("minecraft:block/template_orientable_trapdoor_open", wrapped_texture)


# DATA
data = f"data/{modid}"


# loot_tables
def drop_self(name):
    return f'{{"type": "minecraft:block","pools": [{{"rolls": 1,"entries": [{{"type": "minecraft:item","name": "{modid}:{name}"}}] ,"conditions": [{{"condition": "minecraft:survives_explosion"}}]}}]}}', name


def ore_drops(intake, output):
    return f'{{"type": "minecraft:block","pools": [{{"rolls": 1,"entries": [{{"type": "minecraft:alternatives","children": [{{"type": "minecraft:item","conditions": [{{"condition": "minecraft:match_tool","predicate": {{"enchantments": [{{"enchantment": "minecraft:silk_touch","levels": {{"min": 1}}}}]}}}}],"name": "{modid}:{intake}"}},{{"type": "minecraft:item","functions": [{{"function": "minecraft:apply_bonus","enchantment": "minecraft:fortune","formula": "minecraft:ore_drops"}},{{"function": "minecraft:explosion_decay"}}],"name": "{modid}:{output}"}}]}}]}}]}}', intake


def other_drop(intake, output):  # eg cobblestone from stone
    return f'{{"type": "minecraft:block","pools": [{{"rolls": 1,"entries": [{{"type": "minecraft:item","name": "{modid}:{output}"}}] ,"conditions": [{{"condition": "minecraft:survives_explosion"}}]}}]}}', intake


# recipies
def mono_recipe(shape, intake, output):
    return f'{{"type": "minecraft:crafting_shaped","pattern": {shape},"key": {{"x": {{"item": "{intake}"}}}},  "result": {{"item": "{output}","count": 1}}}}', output


def tool_recipe(shape, intake, output):
    return f'{{"type": "minecraft:crafting_shaped","pattern": {shape},"key": {{"x": {{"item": "{intake}"}},"s": {{"item": "minecraft:stick"}}}},  "result": {{"item": "{output}","count": 1}}}}', output


def shapeless_recipe(intakes, output):
    return f'{{"type": "minecraft:crafting_shapeless","ingredients": [{intakes}],"result": {{"item": "{output}"}}}}', output


def smelt_recipe(intake, output, experience, cooking_time):
    return f'{{"type": "minecraft:smelting","ingredient": {{"item": "{intake}"}},"result": "{output}","experience": {experience},"cookingtime": {cooking_time}}}', f'{{"type": "minecraft:blasting","ingredient": {{"item": "{intake}"}},"result": "{output}","experience": {experience},"cookingtime": {cooking_time}}}'


# USABLE COMMANDS
def custom_item(name):  # makes all the non-texture files for an item made with new Item(properties)
    return jsonize(model("item/generated", {'"layer0"': f'"{modid}:items/{name}"'})), name


def file_item(item):
    make_file(f'{assets}/models/item', f'{item[1]}.json', item[0])
    # append_lang(f'item.{modid}.{item[1]}:{item[1].replace("_"," ").title()}') #rewrite append


def file_drops(drops):
    make_file(f'{data}/loot_tables/blocks', f'{drops[1]}.json', jsonize(drops[0]))


def file_recipe(recipe):
    make_file(f'{data}/recipes', f'{recipe[1][len(modid)+1:]}.json', jsonize(recipe[0]))


def file_object(block):
    # append_lang(f'item.{modid}.{block.name}:{block.name.replace("_"," ").title()}') # add name to en_us.json
    file_item(block.item)  # itemmodel
    make_file(f'{assets}/blockstates', f'{block.name}.json', jsonize(block.blockstate))  # blockstate
    for key, val in block.models.items():
        make_file(f'{assets}/models/block', f'{block.name}{key}.json', jsonize(val))  # blockmodels

# add sapling?

# test
# file_object(Block("jade_ore"))
# file_drops(ore_drops("jade_ore","jade"))
# file_item(custom_item("jade"))
# file_recipe(mono_recipe('["xxx","xxx","xxx"]', 'myfirstmod:jade', 'myfirstmod:jade_block'))
# file_recipe(tool_recipe('["x","s","s"]', 'myfirstmod:jade', 'myfirstmod:jade_shovel'))
# file_recipe(shapeless_recipe())
# file_recipe(smelt_recipe())


file_recipe(mono_recipe("x","myfirstmod:cherry_wood", "myfirstmod:cherry_planks"))
