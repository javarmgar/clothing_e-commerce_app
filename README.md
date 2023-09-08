# Clothing E-Commerce App

## Overview

The Clothing E-Commerce App serves as a platform where buyers can explore and purchase used clothes. This app particularly focuses on allowing sellers to list their used clothes, and buyers can set their location to browse items nearby. A unique feature of the app is the geolocation-based search, enabling buyers to find clothing items within their vicinity.

## Features

- **User Registration & Authentication**: Buyers can sign up and sign in to access the app's features.
- **Geolocation-based Search**: Buyers set their location and specify a radius to search for clothing items around them.
- **Detailed Clothing Listings**: Each listing provides a comprehensive view of the clothing item, including pictures, description, price, and seller information.
- **Categories & Filters**: Users can browse items by categories and apply various filters to refine their search.
- **Interactive Map**: Upon selecting a location, users are presented with an interactive map to fine-tune their location preference.

## Getting Started

### Prerequisites

- Android Studio
- Kotlin SDK
- A device or emulator running Android (API level 21 or higher)

### Installation

1. Clone the repository:
   ```bash
   git clone git@github.com:javarmgar/clothing_e-commerce_app.git
1. Open the project in Android Studio.
1. Build and run the app on an emulator or device.

### App Architecture

As we are working in an Android project the Clean Architecture has been applied to the android App and some changes and adjustments were done.

Here's a diagram of the App Architecture.<br>
  <img width="800" alt="image" src="https://github.com/javarmgar/FetchExercise/assets/21993768/0b4979b6-959d-4930-a842-cf8da93c594d">
  
#### Android Components
Fetch Exercise App is composed by the following android components.
- **core component**:
  - It holds only abstract entities i.e. interfaces and abstract classes, by decoupling abstract entities from concrete implementations we can make a reusable project. This component can be later reusable from other components namely Android TV apps, automobile apps and so on.
  - Additionally this component DO NOT have access to Android SDK, forcing developers to correctly implement **SOLID** principles
- **app component**: This is the actual app, it has access to android SDK and libraries. Core component is imported as a local dependency, then concrete classes implement core interfaces and abstract classes.

## Flow navigation 

![Flow_navigation](https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/a7db67cb-9045-465a-be85-9e5b9e0e8f43)

## Screenshots

Below are some screenshots showcasing key features of the Clothing E-Commerce App.

**Get started, Sign In and Sign up**

<img width="220" alt="clothing_1" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/c58ea7fb-3785-4214-8a03-03f6f8677edb">
<img width="220" alt="clothing_2" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/9da4aece-68c7-46e0-b721-7ebae7dfd4bc">
<img width="220" alt="clothing_3" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/2431271f-8da6-45ed-a679-2985a652d736">

**Home, Filters and Cloth Details**

<img width="220" alt="clothing_4" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/26b4da0b-4fdd-4713-866b-69cac1e0ef4a">
<img width="220" alt="clothing_5_1" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/13fb76d1-01a9-4f7f-989f-5d1df9283f7f">
<img width="220" alt="clothing_5_2" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/fedbc80f-3d61-4676-9aa3-d7f61f1e64cd">
<img width="220" alt="clothing_6" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/5c31eae4-7c74-4600-ad02-5705fb185efa">

**Cart Screen**

<img width="220" alt="clothing_7" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/8be196b7-0bb4-428f-a91a-7d86fbb95204">

**Chooser and creator client Address**

<img width="220" alt="clothing_8" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/1f8e5cf6-acb7-46e7-9e51-9b28a164cd14">
<img width="220" alt="clothing_9" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/34e08fab-9172-4402-95e7-9e8bc077fe83">


**Payment method picker**

<img width="220" alt="clothing_10" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/11dafe47-6e10-4d23-a777-f92fd3b7199d">

**Review and confirm and Purchase done**

<img width="220" alt="clothing_11" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/57eddbc9-62e6-40d7-b30a-ea3e2135d5f6">
<img width="220" alt="clothing_12" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/ca25ac6c-44d0-41b4-b233-1c634f847105">

**Select and create location**

<img width="220" alt="clothing_13" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/ffc63b9b-1067-4848-9d4b-ad0a5a6bda84">
<img width="220" alt="clothing_14" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/caf57c7b-32ef-401a-8ba4-8ec8a7ffe9a9">

**Dialogs**

<img width="220" alt="clothing_15_1" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/565c7659-a348-4ef2-a37f-7efafaea4e2b">
<img width="220" alt="clothing_15_2" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/2c607784-ade9-4cfc-9c8d-72fb764b549f">
<img width="220" alt="clothing_15_3" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/7a435cc8-f007-49de-80dc-82438f585e46">
<img width="220" alt="clothing_15_4" src="https://github.com/javarmgar/clothing_e-commerce_app/assets/21993768/fca6dace-4503-40f8-8b1f-aaf1084c092e">

