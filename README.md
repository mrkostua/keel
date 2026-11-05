# Keel

A habit tracker for **building good habits and quitting bad ones**, written with Kotlin Multiplatform and
Compose Multiplatform. Built as a learning project and a tool for personal use.

Core ideas:

- **Build + quit habits.** Track "did it" (check-off), time (e.g. workout 60 min) or counts (e.g. 2 L water).
- **Relapse-safe streaks.** A slip never erases history: current streak, best streak and total days are all kept.
- **Weekly and monthly statistics.** Totals, days target met, averages and comparison with the previous period.
- **Local-first.** Your data stays on your device, with export/import backup (planned).

> Status: project skeleton (Milestone 0). The app currently shows a placeholder screen on every platform.

## Targets

| Platform | Status |
|---|---|
| Android | builds and runs |
| Desktop (JVM) | builds and runs |
| iOS | Kotlin targets and framework configured; Xcode project not added yet |

## Project layout

| Module | Purpose |
|---|---|
| `shared` | Domain and data layer (pure Kotlin, no UI). Uses `expect`/`actual` for platform specifics. |
| `composeApp` | Compose Multiplatform UI shared by all platforms. Exports the `ComposeApp` iOS framework. |
| `androidApp` | Android application entry point. |
| `desktopApp` | Desktop (JVM) application entry point. |
| `iosApp` | (planned) Xcode project hosting the `ComposeApp` framework. |

## Requirements

- JDK 17 (Gradle 9 needs 17 or newer; the project is built and tested with 17)
- Android SDK (the build downloads missing platforms if licenses are accepted); Android Studio is recommended
- Xcode (full install, not only Command Line Tools) for the iOS target

## Build and run

```bash
# Run the desktop app
./gradlew :desktopApp:run

# Build the Android debug APK
./gradlew :androidApp:assembleDebug

# Tests
./gradlew :shared:desktopTest :shared:testAndroidHostTest

# Lint / format (ktlint via Spotless)
./gradlew spotlessCheck
./gradlew spotlessApply
```

## Tech stack

Kotlin 2.4, Compose Multiplatform 1.12, Android Gradle Plugin 9, Gradle 9.8, kotlinx-coroutines,
kotlinx-datetime. Planned: SQLDelight, Koin, multiplatform ViewModel and Navigation, Kermit.
Versions are pinned in [`gradle/libs.versions.toml`](gradle/libs.versions.toml).

## Roadmap

0. Repo and tooling (in progress)
1. Domain and data (models, SQLDelight, streak and statistics logic)
2. Core UI (habit list, create/edit, daily check-in)
3. Statistics screens
4. Reminders
5. Polish, backup/export, release prep
6. Apple Watch companion
