# ReturnPal Android App

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Design Details](#design-details)
- [Installation](#installation)
- [Usage](#usage)

## Introduction

This app provides an easy and convenient way for clients of ReturnPal to schedule and track their returns from their Andriod device.

## Features

- Intuitive, user-friendly graphical interface.
- Secure Connection to ReturnPal's server.
- Ability to manage a ReturnPal user account.
- Ability to manage pricing plan with ReturnPal.
- Ability to schedule returns with ReturnPal.
- Ability to contact ReturnPal directly via help chat.

## Design Details

### Decomposition Description

#### RETURNPAL SERVER:

We follow the client-server design pattern. Each server can service multiple clients. Clients can come from a web or mobile app. The clients request a service from a ReturnPal server who processes the request and responds to the client with the requested service. The services that the ReturnPal server provides include notifications, access to pickup information, payment options, login, and account creation. Payment is handled by Stripe which is an external service. Notifications to drivers and users will be handled on an event bus. The driver will be notified when a package is scheduled. Then users will be notified of the package status.


#### RETURNPAL DATABASE:

Only the server interacts directly with the database but the client can read and write to the database indirectly through requests.

#### LOGIN OR CREATE ACCOUNT:

Clients can login via email which involves matching an email and password with one in the database. Account creation involves inserting an email and password into the database. Clients can also login via an external third-party service like Google.

#### RETURNPAL ANDROID APP:

We use the repository design pattern to represent the server within the mobile app. A repository is a class that wraps around one (and only one) data source and mediates reading and writing to that data source. In this case, the data source is a connection to the ReturnPal server. Data exposed by this repository should be immutable so that it cannot be tampered with outside the repository. Repositories allow us to abstract the data-related operations away from the rest of the application.

We use ViewModel objects to format data from the repository in such a manner that it can be processed by the UI layer. This way UI elements are not coupled to any specific repository implementation.

Both patterns used in conjunction facilitate a layered architecture. In layered architecture, we enforce a separation of concerns within the application, keeping the implementation of all data-related operations strictly within a data layer and all UI-related operations within the UI layer.


### Design Rationale

We included 3rd party login options to better authenticate members rather than just one. Including login options for Facebook and Google provides a modern experience for the user.

We included 3rd party payment options. More accessible payment options make the user experience easier to pay. Including more payment options is additional overhead for the development team. Each payment option is another component that could potentially fail.

The client-server design was chosen because we have decided to purchase and own our server. We discussed a serverless option using AWS to provide more scalability and reduced maintenance. The maintenance upkeep and reliability issues with owning a server are not a concern. We decided we do not need the scalability provided. We will look at a serverless option again when we expand the service area. AWS offers additional tech support and safer deployment options and easier to revert back to previous deployments.

We believe that the client-server design will provide the most accessibility to users on their devices. The design will also simplify making changes to the software. Puting the implementation of important services in the server rather than the application means that these services can change without needing to update the mobile application or website. The server could be overloaded on the network or on processing power. We plan to keep the business logic on the server simple to reduce processing needs. We plan to reduce network communication between client and server to the events when the database is changed.

The layered design is highly recommended for Andriod's development. A layered architecture allows simultaneous development of both layers. Separating the data layer from the UI layer means that layers stay decoupled and significant changes can be made to one layer without affecting the other layer.

Using the layered design allows us to use tools like Jetpack Compose. Jetpack Compose simplifies creating the UI layer.

The event bus will provide a simple way for the developer to implement notifications. Event Bus does not provide the most reliable method for notifications. Information could be lost in network communication.

## Installation

TODO *Provide instructions on how to install your project. Include any dependencies or prerequisites.*

```
$ git clone https://github.com/your-username/your-repo.git
$ cd your-repo
$ npm install  # or any other relevant command
```

## Usage

TODO *Show how someone would use the app.*
