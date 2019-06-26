# EdkalChallenge

In this application, the MainViewModel plays the role of the LedManager. I used the ViewModel from the architecture components because it survives orientation changes, so if the user rotates the device, the light continues blinking without restarting. I used a sealed class instead of enums because it can hold state, so it makes it easy to add another use case in the future.
