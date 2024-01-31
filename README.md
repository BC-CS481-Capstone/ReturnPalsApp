# ReturnPal Android App

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Design Details](#design-details)
- [Installation](#installation)
- [Usage](#usage)

## Introduction

This app provides an easy and convenient way for clients of ReturnPal to schedule and track their returns from their Android device.

## Features

- Intuitive, user-friendly graphical interface.
- Secure Connection to ReturnPal's server.
- Ability to manage a ReturnPal user account.
- Ability to manage pricing plan with ReturnPal.
- Ability to schedule returns with ReturnPal.
- Ability to contact ReturnPal directly via help chat.

## Design Details

![image](/assets/images/SoftwareDesignOverview.png)

### Layered Architecture

We use a layered architecture, keeping the implementation of all data-related operations strictly within a data layer and all UI-related operations within the UI layer. This enforces a separation of concerns within the application. Layers are decoupled and significant changes can be made to one layer without affecting the other layer, allowing simultaneous development of both the UI and Data layer. In addition this isolates bugged code and makes long-term maintenance easier.

![image](/assets/images/mad-arch-overview-ui.png)

![image](/assets/images/mad-arch-overview-data.png)

TODO *combine the two images above into one image without the domain layer* 

### Repository

We use the repository design pattern to represent the server within the mobile app. A repository is a class that wraps around one (and only one) data source and mediates reading and writing to that data source. In this case, the data source is a connection to the ReturnPal server. Data exposed by this repository should be immutable so that it cannot be tampered with outside the repository. Repositories allow us to abstract the data-related operations away from the rest of the application.

### ViewModel

We use ViewModel objects to format data from the repository in such a manner that it can be processed by the UI layer. This way UI elements are not coupled to any specific repository implementation.

## Installation

TODO *Provide instructions on how to install your project. Include any dependencies or prerequisites.*

```
$ git clone https://github.com/your-username/your-repo.git
$ cd your-repo
$ npm install  # or any other relevant command
```

## Usage

TODO *Show how someone would use the app.*
