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

## Frontend Design Details

![image](/assets/images/architecture.png)

### Layered Architecture

We use a layered architecture, keeping the implementation of all data-related operations strictly within a data layer and all UI-related operations within the UI layer. This enforces a separation of concerns within the application. Layers are decoupled and significant changes can be made to one layer without affecting the other layer, allowing simultaneous development of both the UI and Data layer. In addition this isolates bugged code and makes long-term maintenance easier.

![image](/assets/images/mad-arch-overview-ui.png)

![image](/assets/images/mad-arch-overview-data.png)

TODO *combine the two images above into one image without the domain layer* 

### Repository

We use the repository design pattern to represent the server within the mobile app. A repository is a class that wraps around one (and only one) data source and mediates reading and writing to that data source. In this case, the data source is a connection to the ReturnPal server. Data exposed by this repository should be immutable so that it cannot be tampered with outside the repository. Repositories allow us to abstract the data-related operations away from the rest of the application.

### ViewModel

We use ViewModel objects to format data from the repository in such a manner that it can be processed by the UI layer. This way UI elements are not coupled to any specific repository implementation.

## Backend Design Details

### AWS Amplify

We are using AWS Amplify to host our user pools and data tables. AWS provides users a single entry point to access multiple AWS micro services.

We are using DynamoDB, Cognito, and S3 buckets behind the Amplify API. 

![AWS services.png](assets%2Fimages%2FAWS%20services.png)

## Contributing

1. Download the latest version of Android Studio.
2. Clone the remote repository onto your device:  `git pull https://github.com/BC-CS481-Capstone/ReturnPalsApp`
3. Create a development branch:  `git checkout -b <your_branch_name>`
4. Save the changes made to your branch:  `git add <filename>` && `git commit -m "did a thing"`
5. Upload changes to the remote repository:  `git push --set-upstream origin master`
6. Make a pull request.
7. Wait for feedback.

We are always looking for improvements to our UI.
 * Create issues for missing information or incorrect scaling.
 * Solve issues of incorrect scaling or missing content.
 * Create issues for request to change on backend.
 * Add new features:
   * Add live chat for chatting with drivers.
   * Add live tracking of pickup.

## License
TODO *Specify the license under which your project is distributed. For example, MIT License, Apache License, etc.*
