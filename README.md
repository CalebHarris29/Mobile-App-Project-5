# Android Project 5 - Hydration Tracker

Submitted by: **Caleb Harris**

**Hydration Tracker** is a health metrics app that allows users to track their daily water consumption and hydration levels offline, view past entries in a scrollable RecyclerView, and monitor daily progress in real time. 

Time spent: **6** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **At least one health metric is tracked (based on user input)**
  - Chosen metric(s): `Water Intake (ml) & Optional Notes`
- [x] **There is a "create entry" UI that prompts users to make their daily entry**
- [x] **New entries are saved in a database and then updated in the RecyclerView**
- [x] **On application restart, previously entered entries are preserved (i.e., are *persistent*)**
 
The following **optional** features are implemented:

- [ ] **Create a UI for tracking averages and trends in metrics**
- [x] **Improve and customize the user interface through styling and coloring** (Material 3 CardViews, custom buttons, and edge-to-edge layout)
- [ ] **Implement orientation responsivity**
- [ ] **Add a daily photo feature**

The following **additional** features are implemented:

- [x] Real-time daily total water calculation and item deletion capability.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

<!-- Replace this with whatever GIF tool you used! -->
GIF created with ...  
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes

Building an offline-first app with modern Android architecture presented interesting challenges, particularly configuring Room database compilation with KSP under the latest Android Gradle Plugin versions. Utilizing Kotlin Coroutines and Flows allowed for reactive, seamless database updates directly to the RecyclerView adapter without blocking the main thread.

## License

    Copyright 2026 Caleb Harris

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
