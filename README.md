# Random_String_generate



Random String Generator Android App
This is an Android app that queries a random string from an existing Android content provider. The content provider generates random strings and returns them with metadata in JSON format. This app uses MVVM architecture and Jetpack Compose for the UI.

Functional Requirements
Set String Length:
The user can set the length of the string that should be generated.

Query Content Provider:
After the user sets the length, the app queries the content provider for a random string with the specified length.

Display Generated String:
Every generated string from the content provider will be displayed with the following details:

The generated string.
The length of the string.
The time and date when the string was created.
Persistence of Old Strings:
Old generated strings should still be visible to the user when a new string is generated.

Delete Strings:

Option to delete all previously generated strings.
Option to delete a single generated string.
Error Handling:
The app includes error handling to manage potential failures.

Features of Content Provider
Authority: com.iav.contestdataprovider
MIME-Type: vnd.android.cursor.dir/text
Data Uri: content://com.iav.contestdataprovider/text
Data Column Name: data
Limit Parameter: ContentResolver.QUERY_ARG_LIMIT
Permissions:
Read: com.iav.contestdataprovider.READ
Write: com.iav.contestdataprovider.WRITE
Content: The content provider returns a JSON response in the following format:

{
  "randomText": {
    "value": "oiahsfdoaoufbou9s",
    "length": 19,
    "created": "2024-10-02T07:38:49Z"
  }
}
Project Structure
MVVM Architecture: The app follows the Model-View-ViewModel (MVVM) architecture to separate the logic from the UI.
Jetpack Compose: Used for building the UI components in a modern, declarative manner.
Content Provider Integration: Uses the provided content provider to fetch random strings.
Setup Instructions
Clone the Repository:

git clone https://github.com/sachinrajputd/Random_String_generate.git
Open the Project:

Open the project in Android Studio.
Permissions:
 uses-permission android:name="com.iav.contestdataprovider.READ" 
 uses-permission android:name="com.iav.contestdataprovider.WRITE"

Run the App:
Build and run the app on a device or emulator.

Technologies Used
Kotlin: The app is developed using Kotlin as the primary language.
MVVM: For clean architecture and separation of concerns.
Jetpack Compose: For building the user interface.
Content Provider: For querying random strings.
