# Shortify for Android

Shortify is used for minimizing your coding effort in your development environment. It has some builtin method and classes which helps you in creating mostly used element and tasks in Android app.
##Download
Grab library via Gradle
```groovy
compile 'net.dhruvpatel:shortify:1.2.2'
```
or Maven
```xml
<dependency>
  <groupId>net.dhruvpatel</groupId>
  <artifactId>shortify</artifactId>
  <version>1.2.2</version>
  <type>pom</type>
</dependency>
```

##Features

- [Binding of views](#binding-of-any-views)
- [Binding of resources](#binding-of-resources)
- [Customize views](#customize-views)
- [Parsing JSON data](#parsing-json-data)
- [AJAX](#ajax)
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
String str           = $.bindString(R.string.app_name);
Drawable drawable    = $.bindDrawable(R.drawable.example);
Animation animation  = $.bindAnimation(R.anim.animation1);
.
.
.
//List of binders
$.bindString(R.string.example);
$.bindDimension(R.dimen.example);
$.bindAnimation(R.anim.example);
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
## Parsing JSON data
Shortify can parse long and complex JSON data in simplest way. You can parse any type of data like `integer`, `long`, `double`, `boolean`, `String`
```java
int value = $.getIntFromJSON(path, JSON_STRING);
String str = $.getStringFromJSON(path, JSON_STRING);
long value = $.getLongFromJSON(path, JSON_STRING);
double value = $.getDoubleFromJSON(path, JSON_STRING);;
boolean value = $.getBooleanFromJSON(path, JSON_STRING);
```
> ### Example 1
  ```json
  {
      "$schema": "http://json-schema.org/draft-04/schema#",
      "title": "Product",
      "description": "A product from Acme's catalog",
      "type": "object",
      "properties": {
          "id": {
              "description": "The unique identifier for a product",
              "type": "integer"
          },
          "name": {
              "description": "Name of the product",
              "type": "string"
          },
          "price": {
              "type": "number",
              "minimum": 0,
              "exclusiveMinimum": true
          },
          "tags": {
              "type": "array",
              "items": {
                  "type": "string"
              },
              "minItems": 1,
              "uniqueItems": true
          }
      },
      "required": ["id", "name", "price"]
  }
  ```
  
  1. Now suppose we want to get value of `properties > price > minimum`
  
    ```java
    int value = $.getStringFromJSON("properties.price.minimum", JSON_STRING);
    ```
  2. Suppose we want to get value of `properties > tags > items > type`
  
    ```java
    String value = $.getStringFromJSON("properties.tags.items.type", JSON_STRING);
    ```
  3. If we want to get 2nd element of `required` object
  
    ```java
    String value = $.getStringFromJSON("required[1]", JSON_STRING);
    ```
  ### Example 2
  This example has array of user and no object is assigned to whole array
  ```json
  [
    {
      "name":{
        "first": "first name 1",
        "last": "last name 1"
      },
      "dob":{
        "month": "January",
        "day": 1
      }
    },
    {
      "name":{
        "first": "first name 2",
        "last": "last name 2"
      },
      "dob":{
        "month": "May",
        "day": 2
      }
    }
  ]
  ```
  
  Now suppose we want to get value of 1st user's first name
  ```java
  String name = $.getStringFromJSON("[0].name.first", JSON_STRING);
  ```

##AJAX
Shortify enables you to send AJAX request to server via both GET and POST method and it can also retrive response from webpage
> ###GET method

```java
$.httpGet("http://example.com/rest/api", new AJAX.AJAXCallback() {
    @Override
    public void onComplete(String response) {
        Log.d(TAG, response);
    }
});
```
> ###POST method

```java
HashMap<String, Object> queryStringData = new HashMap<>();
queryStringData.put("name","Dhruv");
queryStringData.put("age",22);
queryStringData.put("auth",true);

$.httpPost("http://example.com/rest/api",queryStringData,  new AJAX.AJAXCallback() {
    @Override
    public void onComplete(String response) {
        Log.d(TAG, response);
    }
});
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
