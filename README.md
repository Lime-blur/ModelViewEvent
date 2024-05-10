# ModelViewEvent

[![release](https://jitpack.io/v/Lime-blur/ModelViewEvent.svg)](https://github.com/Lime-blur/ModelViewEvent/releases/latest)
[![yoptava license](https://img.shields.io/github/license/Lime-blur/ModelViewEvent)](https://github.com/Lime-blur/ModelViewEvent/blob/main/LICENSE)

1. [About](https://github.com/Lime-blur/ModelViewEvent?tab=readme-ov-file#About)
2. [Installation](https://github.com/Lime-blur/ModelViewEvent?tab=readme-ov-file#Installation)
3. [Examples](https://github.com/Lime-blur/ModelViewEvent?tab=readme-ov-file#Examples)

## About

<a href="https://github.com/Lime-blur/ModelViewEvent/">
  <p align="center">
    <img src="https://github.com/Lime-blur/ModelViewEvent/blob/main/images/architecture.png" width="512">
  </p>
</a>

The library simplifies the implementation of the MVI architecture by imposing certain implementation rules.
Pay attention to the implementation diagram. In order to implement the architecture, it is necessary:
- First of all, create sealed classes ViewEvent and ViewState, which implement the [BaseViewEvent](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/base/BaseViewEvent.kt) and [BaseViewState](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/base/BaseViewState.kt) interfaces, respectively. This is necessary to ensure that all ViewEvents and ViewStates are of type [BaseViewEvent](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/base/BaseViewEvent.kt) and [BaseViewState](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/base/BaseViewState.kt) respectively
- After that, create a ViewModel class that inherits from the abstract [MVEViewModel](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/viewmodel/MVEViewModel.kt) class. The ViewModel class must implement a method for listening to ViewEvents coming from the UI. The ViewModel also has ready-made methods that get and change the current ViewState
  - If you need your own implementation of ViewModel, or you don't use ViewModel at all, you can inherit from the abstract class [MVECustomViewModel](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/viewmodel/MVECustomViewModel.kt)
  - Please note that the [MVEViewModel](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/viewmodel/MVEViewModel.kt) has exactly one _viewState field, which is of type [SingleLiveEvent](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/lifecycle/SingleLiveEvent.kt). This limitation ensures that the UI is unique and easy to update. No need to track a large number of different data sources
- Next, you need to create an abstract class that inherits from the Fragment class and implements the [MVEUserInterface](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/ui/MVEUserInterface.kt) interface. This abstract class will listen to ViewStates coming from the ViewModel and call the corresponding abstract methods. This class also performs the role of sending ViewEvents to the ViewModel. This class should not perform any other functions!

Thus, when creating a new Fragment, we do not need to create unnecessary methods for listening to ViewStates and sending ViewEvents, which pollute the current logic.

The library also has utility methods:
- MVEViewModel.setState - changes the current ViewState. Use this function only if you want to change the ViewState outside of [MVEViewModel](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/viewmodel/MVEViewModel.kt) or [MVECustomViewModel](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/viewmodel/MVECustomViewModel.kt)
- MVEUserInterface.triggerEvent - used to send ViewEvent to ViewModel. Use this function only if you want to send ViewEvent to ViewModel outside of [MVEUserInterface](https://github.com/Lime-blur/ModelViewEvent/blob/main/modelviewevent/src/main/java/ru/limedev/modelviewevent/ui/MVEUserInterface.kt)

## Installation

Add this dependency to your module's `build.gradle` file:

```gradle
dependencies {
  ..
  implementation 'com.github.Lime-blur:ModelViewEvent:latest_version'
}
```

Add it in your root build.gradle at the end of repositories (or in settings.gradle):

```gradle
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
  }
}
```

## Examples

See the sample module: https://github.com/Lime-blur/ModelViewEvent/blob/main/sample
