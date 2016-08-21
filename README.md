# Shortify for Android

Shortify is used for minimizing your coding effort in your development environment. It has some builtin method and classes which helps you in creating mostly used element and tasks in Android app.
##Download
Grab library via Gradle
```groovy
compile 'net.dhruvpatel:shortify:1.0.1'
```
or Maven
```xml
<dependency>
  <groupId>net.dhruvpatel</groupId>
  <artifactId>shortify</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```
##Features

- [Binding of views](#binding-of-any-views)
- [Binding of resources](#binding-of-resources)
- [Customize views](#customize-views)
- [Event handlers](#event-handlers)
- [Dialogs](#dialogs)
- [Other functions](#other-functions)

##How to use
Initialize library before using it in `onCreate` method
```java
$.init(this);
```

##Binding of any views
```java
// Basic 
EditText editText = (EditText) context.findViewById(R.id.editText1);
com.example.view.CustomView customView = (com.example.view.CustomView) context.findViewById(R.id.view);

// Shortify
EditText editText = $.bind(R.id.editText1);
com.example.view.CustomView customView = $.bind(R.id.view);
```

##Binding of resources
```java
// Basic 
String str = getApplicationContext().getString(R.string.app_name);
Drawable drawable = getApplicationContext().getDrawable(R.drawable.example);
Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation1);

// Shortify
String str           = $.bindStr(R.string.app_name);
Drawable drawable    = $.bindDrawable(R.drawable.example);
Animation animation  = $.bindAnim(R.anim.animation1);
.
.
.
//List of binders
$.bindStr(R.string.example);
$.bindDimen(R.dimen.example);
$.bindAnim(R.anim.example);
$.bindDrawable(R.drawable.example);
$.bindColor(R.color.example);
$.bindInteger(R.integer.example);
$.bindBoolean(R.bool.example);
```

## Customize views
```java
//Basic
TextView textView = (TextView) findViewById(R.id.textView);
textView.setText(getApplicationContext().getString(R.string.app_name));
textView.setTextColor(Color.BLUE);
textView.setTextSize(16f);
textView.setAllCaps(true);
Linkify.addLinks(textView, Linkify.ALL);

//Shortify
$.id(R.id.textView).text(R.string.app_name)
   .color(Color.BLUE)
   .size(16)
   .allcapital()
   .linkify();
```

## Event handlers
```java
//Basic
Button button = (Button) findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ...
    }
});
   
//Shortify     
$.id(R.id.button).click(new Task() {
    @Override
    public void perform() {
        ...
    }
});
```

## Dialogs
```java
//Simple alert dialog box
$.alertDialog("Title","Description");

//Generates and shows dialog with OK button with onClick event handlers
$.confirmDialog("Title", "Description", new Click() {
    @Override
    public void ok() {
                
    }
});

//Generates and shows dialog with YES and NO button with onClick event handlers
$.yesNoDialog("Title", "Description", new Agree() {
    @Override
    public void yes() {
            
    }

    @Override
    public void no() {

    }
});
 ```
 
##Other functions
```java
//Check, if app is installed or not in device 
$.checkIfAppInstalled(PKG_NAME);

//Open current or any other app page in Play store app
$.openAppInStore();
$.openAppInStore(PKG_NAME);

//Showing toast
$.toast(MESSAGE);

//Get current date and time in any format
$.time("d m y");

//Check app permission (used for Runntime Permission Model)
$.checkPermission(PERMISSION_STRING);

//Navigate to any activity with or without passing data
$.open(Activity.class);
$.open(Activity.class, bundle);
```

Thanks for using. if you have any suggestions or bug report please create new issue [here](https://github.com/dhruv1110/Android-Shortify/issues)
