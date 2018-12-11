## News app

A News app that shows the latest live top and breaking news headlines in the US right now;

The application is very simple: The main page opens with the list of the latest articles,
clicking on the desired article item leades you to the url article web page.
Clicking on back button will return to the articles list.

Though the application idea is very simple it built with the latest technology:
- Dagger2
- Retrofit
- MVP concept: Model, View, Presenter
I also prepared the ground for realm for developing more complex application, but in the end i realised it has no need here.

For the future, if i had more time i would add these:
- View design, fonts, images
- Added splash icon, and display loading sign.
- Added place holder for the images (displays while the imge is rendering from the web)
- Took care the edge cases: 
    - In case there is no internet -> display text.
    - In case the url of the article is incorrect or isnt working -> display text.
    - What to display in case one of the article item propertu is missimg: Image, title, date or content -> handle the display.
    - Created tests;
    - Added infinity scrolling, loadded more articles if available.
    - back button on action bar
    - could add more options and functionality.
    
    
## Get the code

```
$ git clone https://github.com/SophieCoop/NewsApp.git
$ cd NewsApp
```

## Build and run the app

* Import the project into Android Studio, build and run it. Make sure you have internet on 
your mobile device the the news could be shown.
* The APK file is in the root, names:  'NewsApp.apk'

## License
Copyright 2018, Sophie Cooperman, Inc.
