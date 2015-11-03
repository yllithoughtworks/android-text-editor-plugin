#android osgi plugin project

this is some osgi plugin.

notice:  use dx to change class format

~/Library/Android/sdk/build-tools/23.0.0/dx --dex --output=classes.dex foo.jar

~/Library/Android/sdk/build-tools/23.0.0/aapt add foo.jar classes.dex