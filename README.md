Problems with the build : 
  - the heap size was too small
  - android permissions in regards to SDK
  - updated to the newest gradle versions
  
First Bug: I tried the first time fixing it from the preview UI in android studio but all the fields were put in the same place, i fixed that by adding a property app:layout_constraintTop_toBottomOf to most of them so they can be ordered, except for the animation which when adding this property it would go outside of reach. 
In that case i used app:layout_constraintBottom_toTopOf for the animation and i put it on top of the sign in button.

Second Bug: I've read the requirements for all the logic behind it. and i found 3 cases: 1. when every field is populated and then you check if they respect the rules applied to those 2. if the email and password is populated but not the name as it is optional. 3. where the email or password are empty. They have specific errors ( added 2 more for when the email or password is empty ) .

Thirs Bug :  this was the hardest to fix, as i didn't had so much experience in regards to animation or android studio. first in started by looping the animation in the activity_login.xml file , which later i found it was a bad choice in my regards. I tried using the function from lottie onAnimationEnd or something like that which was built in , there was a problem for this as this option is yet to be released for Android Studio. Tried with setting min and max frame from the beginning , but it failed as we didn't loop once and then start changing the frames. In the end it worked with choosing an Animator Listener ( i had some issues with this as well, as onAnimationEnd is not called when the animation ends - last frame is finished - but its called when the animation disappeared from the screen ) , i choosed to call to loop the animation on animation start and in the function on animation repeat to change the frames. 


I didn't finish everything as i had some problems with the api calls, i succeded to add the message and the headers to the call ( which was easy )  but i got an error in regards to the network connection , the fix for that is to add the call in its own class, did that didn't work, the other option was to create a AsyncTask<Void, Void, String> class , tried, didn't work. That was the assessment , even if i am not chosen for this job, it was a good experience as I never used Android Studio before or coding in Kotlin ( which is similar to Java ) 
