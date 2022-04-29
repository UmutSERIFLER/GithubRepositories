# Github Repositories
 Simple GitHub repositories application using Kotlin

## [MVVM(Model-View-ViewModel)](https://en.wikipedia.org/wiki/Model–view–viewmodel)

In general, MVVM is one of popular design pattern that separates Business-Logic-View layers. It also contributes on reducing amount of spending time to write test code. 

This sample project is consisted of 
[DataBinding](https://developer.android.com/topic/libraries/data-binding) and 
[Android Architecture Components](https://developer.android.com/topic/libraries/architecture/))

** Model **
(Used models are Project/User can be found under src/main/service/models directory)
*** ***

⇩

** ViewModel **
(Two viewmodels are used within this sample project ProjectListViewModel/ProjecTviewModel under src/main/viewmodel)
*** ***

⇩

** View **
(activity_main / fragment_project_details / fragment_project_list / project_list_item )
(MainActivity / ProjectFragment / ProjectListFragment)
*** ***

Maintainability is also improved by making the dependency unidirectional.
There are many more detailed articles on design in the world, so I will introduce the details below.

For an understanding of the main designs, refer to the following articles.

** [Introduction to Android Architecture-Understanding the meaning of selection and the characteristics of MVP, Clean Architecture, MVVM, Flux] () **
