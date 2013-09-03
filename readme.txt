=============DISCLAIMER=============
This SOFTWARE PRODUCT is provided by THE PROVIDER "as is" and "with all faults." THE PROVIDER makes no representations or warranties of any kind concerning the safety, suitability, lack of viruses, inaccuracies, typographical errors, or other harmful components of this SOFTWARE PRODUCT. There are inherent dangers in the use of any software, and you are solely responsible for determining whether this SOFTWARE PRODUCT is compatible with your equipment and other software installed on your equipment. You are also solely responsible for the protection of your equipment and backup of your data, and THE PROVIDER will not be liable for any damages you may suffer in connection with using, modifying, or distributing this SOFTWARE PRODUCT.
=============DISCLAIMER=============

=============INTRO=============
This little piece of java code was designed to repeatedly click a key that you can set at a rate of once per 0.2 seconds. This was designed originally to help automate the "Zero Trick". This software has an easy to use interface. Simply click "start" to start the process, when you're finished with the "zero trick" click stop and it will stop pressing your preset key.
=============INTRO=============

=============CONFIG FILE=============
By default this program is set up to use the numpad 0 key as the key to spam. However this is editable and will work with (most) keyboard keys. So even if you can’t use numpad 0 for the "zero trick" you can still use this software you just need to configure it.

Configuring the software is very easy and straight forward:
1. Open zero_trick_helper.conf with your favorite text editor.
2. Change where it says "num0" to any keyboard key.
EX: if you want to use the period key you would change the line to "confirm key = ." (No quotes)
3. Save and you're done. The software should now be ready to use your new key.

NOTE: unfortunately some keys are not supported with hard coded key values, and as such cannot be used.
If you wish to use numpad 0-9 you can write "numN" (no quotes) where n is whichever number you want to use.
For instance if I wanted to use numpad 5 I would set it to "confirm key = num5" (no quotes).
=============CONFIG FILE=============

=============USE=============
To use this product simple:
1. unzip the folder "Zero Trick Helper" (leave the file structure intact if you wish for the program to work correctly).
2. Make sure the zero_trick_helper.conf file is set with the confirm key you wish to use.
3. Run the ZeroTrickHelper.jar.
4. Click the Start button.
5. The program will then wait 3 seconds to give you time to get to your program or text area.
6. After the initial wait period it will start pressing and releasing your selected key at a rate of once every 0.2 seconds.
7. Once your goal has been accomplished go back to the program window and hit the Stop button. This will end the key press loop.
8. After you are finished simply click the close button and the program will exit.
=============USE=============

=============ERRORS=============
This program is not foolproof, and shouldn't be treated as such. However if you read this readme carefully you should have no problems operating it. If however you do come across any error or if the program does not act as intended please send an email to support@wtfhonestly.com

If you receive an error box that states: Error in config file! Please see readme.txt you have a malformed config file and you need to follow the instructions above in the CONFIG FILE section.
=============ERRORS=============

=============CHANGE LOG=============
V0.1 - 2013/09/03 - Initial release
=============CHANGE LOG=============
