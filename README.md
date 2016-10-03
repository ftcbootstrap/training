
# training

This repo was built from the FTC team code template locate here : https://github.com/ftcbootstrap/team-template.

The code here requires the inclusion of the Bootstrap ftc-utilities project located here.   
https://github.com/ftcbootstrap/ftc-utilities

<h1> Installation Instructions </h1>

-Download or clone the this repo along with the dependent ftc-utilities repo to your local machine.  
-Copy the two directories under the ftc-app root project and change the settings.gradle file to look like this:

```
include ':FtcRobotController'
include ':ftc-utilities'
include ':training'
```

Note: If you download either repo as a zip file, make sure the extracted directory name does not have a "-master" suffix and matches the name included in the settings.gradle file above.    Also make sure that the extract directory does not have a another subdirectory with the same name.  If this is the case then copy the lowest level directory under the ftc-app root project.
