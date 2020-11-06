extends Control


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
onready var message = $VBoxContainer/Label;
onready var status = $VBoxContainer/Label2;
onready var text_box =$VBoxContainer/TextEdit;

var has_plugin : bool;
var plugin;

# Called when the node enters the scene tree for the first time.
func _ready():
	if Engine.has_singleton("DemoPlugin"):
		has_plugin = true;
		plugin = Engine.get_singleton("DemoPlugin")
		status.text = "Plugin Available"
		
		plugin.connect("OnSignalTriggered",self,"_on_plugin_signal")
		
	else:
		has_plugin = false;
		status.text="No Plugin";
		status.add_color_override("font_color",Color(0.95,0.2,0.2));
	pass;


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_Button_pressed():
	if has_plugin:
		message.text = plugin.SayHello(text_box.text);


func _on_Button2_pressed():
	if has_plugin:
		plugin.TriggerSignal()
	pass # Replace with function body.


func _on_plugin_signal(text: String):
	message.text = text;
	pass
