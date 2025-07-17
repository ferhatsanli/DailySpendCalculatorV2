# DailySpendCalculatorV2

DailySpendCalculatorV2 is an Android application built with Jetpack Compose that helps users track and analyze their daily spending. The app allows users to import CSV files (such as bank statements) and view the data in a clean, interactive table format.

## Features

- Import CSV files directly from your device or banking app
- Display CSV content in a responsive, scrollable data table
- Clickable table cells with instant feedback (toast messages)
- Material 3 theming with support for dark and light modes
- Modern UI built with Jetpack Compose

## Screenshots

*Coming soon!*

## Getting Started

### Prerequisites
- Android Studio Hedgehog or newer
- Android device or emulator running Android 13 (API 33) or higher

### Build & Run
1. Clone this repository:
   ```sh
   git clone https://github.com/yourusername/DailySpendCalculatorV2.git
   ```
2. Open the project in Android Studio.
3. Connect your device or start an emulator.
4. Click **Run** or use `Shift+F10` to build and launch the app.

### Importing CSV Files
- Share a CSV file from your banking app or file manager to DailySpendCalculatorV2.
- The app will parse and display the CSV content in a table.

## Project Structure

- [`app/src/main/java/com/ferhat/dailyspendcalculatorv2/MainActivity.kt`](app/src/main/java/com/ferhat/dailyspendcalculatorv2/MainActivity.kt): Main entry point, handles CSV import and UI setup
- [`app/src/main/java/com/ferhat/dailyspendcalculatorv2/FileProcesses.kt`](app/src/main/java/com/ferhat/dailyspendcalculatorv2/FileProcesses.kt): Utility for reading CSV files from URIs
- [`app/src/main/java/com/ferhat/dailyspendcalculatorv2/layouts/DataTable.kt`](app/src/main/java/com/ferhat/dailyspendcalculatorv2/layouts/DataTable.kt): Composable for rendering data tables
- [`app/src/main/java/com/ferhat/dailyspendcalculatorv2/ui/theme/`](app/src/main/java/com/ferhat/dailyspendcalculatorv2/ui/theme/): Material 3 theme definitions
- [`app/src/main/AndroidManifest.xml`](app/src/main/AndroidManifest.xml): Intent filters for CSV file handling

## Dependencies
- Jetpack Compose
- Material 3
- Accompanist FlowLayout

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author

Ferhat Sanli

---

*Feel free to contribute or open issues for suggestions and bug reports!*
