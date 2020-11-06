# GodotAndroidPluginDemo

This is a demo of how to create a custom android plugin.

Use this as a baseline for your plugins.

## Structure
---
* `AndroidPlugin` - Android studio project that builds the plugin
  * `DemoLib` - The actual library to be built
* `GodotPlugin` - Files to necessary for Godot to recognise the plugin
* `GodotProject` - Sample Godot project that shows how tot use plugin

## Setup
---
### 1. Building the library and running the Godot project
1. Replace `GodotAndroidPluginDemo\AndroidPlugin\godot-lib.release\godot-lib.release.aar` with the Godot engine library of your choosing
    1. Download the Godot engine library
    2. Copy to the specified location
    3. Delete current `godot-lib.release.aar`
    4. Rename the downloaded file to `godot-lib.release.aar`
2. Run `gradlew build` in `GodotAndroidPluginDemo\AndroidPlugin`
3. Copy `GodotAndroidPluginDemo\AndroidPlugin\DemoLib\build\outputs\aar\DemoLib-release.aar` to `GodotAndroidPluginDemo\GodotPlugin`
4. Rename `DemoLib-release.aar` to `DemoPlugin.aar`
5. Copy both files from `aa` to `aa`
6. Follow [these steps](https://docs.godotengine.org/en/stable/getting_started/workflow/export/android_custom_build.html#doc-android-custom-build) to set up Godot to build for android
7. Build the godot project and run
    * Export `apk` and install on phone
    * Activate `developer mode` on android and enable `USB debugging` in `developer options`

### 2. Customizing the project

1. Open `GodotAndroidPluginDemo\AndroidPlugin` project in Android Studio
2. Modify `AndroidPlugin\DemoLib\AndroidManifest.xml` for requirements
3. Modify `AndroidPlugin\DemoLib\src\main\java\com\gd\android\demolib\InstantiateSingleton.java` for functionality

## Maintenance
---
In `GodotAndroidPluginDemo\AndroidPlugin\DemoLib\src\main\AndroidManifest.xml` change `android:name` in the `<meta-data\>` tag to point to the latest version (e.g. `godotengine.plugin.v##.[Name]`)