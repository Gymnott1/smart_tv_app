# Amazon TV Connection Guide

A Kotlin Android TV app that serves as a comprehensive TV connection guide with QR code pairing, step-by-step instructions, and device information.

## Features

### 🎨 Design
- **Dark Theme** with orange accent colors (#FF5500)
- **Material Design** components optimized for TV
- **Gradient orange header** with TV icon and app title
- **10-foot UI** experience with proper padding and focus handling

### 📱 Main Sections

#### 1. QR Code Screen
- Centered QR code generator with refresh functionality
- Connection ID display
- Mobile pairing instructions
- D-pad navigation support

#### 2. Guide Section
- Step-by-step connection instructions
- WiFi, Ethernet, and mobile hotspot setup
- Card-based layout with numbered steps
- Relevant icons for each connection type
- RecyclerView implementation

#### 3. About Section
- App information in card format
- Icons for app purpose, mobile requirements, privacy, and support
- RecyclerView implementation

### 🎮 Navigation
- **Tab-based navigation** with D-pad support
- **LEANBACK_LAUNCHER** intent integration
- **Focus handling** optimized for TV remote
- **Navigation hints** in footer

### 📺 TV Optimization
- **TV device detection** with warning for non-TV devices
- **Android TV leanback** integration
- **CardView** and **LinearLayout** for proper TV layouts
- **RecyclerView** for scrollable content sections

## Technical Stack

- **Language**: Kotlin
- **Platform**: Android TV
- **UI Components**: Material Design, CardView, RecyclerView
- **Navigation**: Tab-based with D-pad support
- **Theme**: Dark theme with orange accents
- **QR Code**: Integrated QR code generation

## Requirements

- Android TV device or emulator
- Android API level compatible with TV platform
- D-pad or TV remote for navigation

## Installation

1. Clone the repository
2. Open in Android Studio
3. Build and deploy to Android TV device
4. Launch from TV launcher

## Usage

1. **QR Code Tab**: Generate and refresh QR codes for mobile pairing
2. **Guide Tab**: Follow step-by-step connection instructions
3. **About Tab**: View app information and requirements
4. Use D-pad to navigate between tabs and content

## Color Scheme

- **Primary**: Dark theme background
- **Accent**: Orange (#FF5500)
- **Header**: Orange gradient
- **Cards**: Material Design dark cards

## TV-Specific Features

- Leanback launcher integration
- TV device detection and warnings
- Optimized focus handling
- 10-foot UI design principles
- D-pad navigation throughout the app