# 🎓 Java Master Quiz Application

<div align="center">
  <img src="https://img.shields.io/badge/Java-11%2B-orange.svg" alt="Java Version">
  <img src="https://img.shields.io/badge/Swing-GUI-blue.svg" alt="Java Swing">
  <img src="https://img.shields.io/badge/Architecture-MVC-brightgreen.svg" alt="MVC Architecture">
  <img src="https://img.shields.io/badge/Status-Active-success.svg" alt="Status">
</div>

<p align="center">
  A modern, feature-rich Java desktop application designed to test and improve your programming knowledge. 
</p>

---

## 📑 Table of Contents
- [About the Project](#-about-the-project)
- [Key Features](#-key-features)
- [Architecture & Tech Stack](#-architecture--tech-stack)
- [Getting Started](#-getting-started)
- [Usage](#-usage)
- [Development Journey (Changelog)](#-development-journey-changelog)
- [Contributing](#-contributing)
- [License](#-license)

## 🚀 About the Project
Java Master Quiz is an interactive desktop application built using Java Swing. Evolving from a basic monolithic design into a robust, layered architecture, it offers a seamless user experience for taking quizzes across various programming categories like Core Java, OOP, and Collections.

## ✨ Key Features
- **Secure Authentication**: File-based robust user login and registration system.
- **Dynamic Quiz Engine**: Timed questions, progress tracking, and category selection.
- **Modern UI/UX**: Sleek, custom-styled Swing components with interactive hover effects and smooth transitions.
- **Admin Dashboard**: Specialized interface for adding, modifying, and deleting question banks.
- **Global Leaderboard**: Competitive scoring system that tracks top performers.
- **Automated Seeding**: Python-based script (`tmp_generate_qs.py`) to auto-populate high-quality questions.

## 🏗️ Architecture & Tech Stack
The project adheres to strict **Separation of Concerns (SoC)** through a custom MVC-inspired layered architecture:
- **Language**: Java SE
- **UI Framework**: Java Swing & AWT
- **Data Persistence**: Flat-file database (`.txt` files with custom parsers)
- **Scripting**: Python (for automated data generation)

### Directory Structure
```text
newjavaquiz/
├── assets/         # UI Images, Icons, and visual assets
├── data/           # Persistent storage (users.txt, questions.txt, leaderboard.txt)
├── src/
│   ├── model/      # Data Transfer Objects (User, Question, QuizResult)
│   ├── service/    # Business logic (AuthService, QuizService, etc.)
│   ├── ui/         # View layer and Swing Frames
│   ├── util/       # Utility classes (Hashing, Timers)
│   └── Main.java   # Application entry point
└── tmp_generate_qs.py # Question generator script
```

## 💻 Getting Started

### Prerequisites
- **Java Development Kit (JDK)** 11 or higher.
- **Python 3.x** (optional, only required if you want to generate new questions).

### Installation
1. Clone the repository or download the source code.
```bash
git clone https://github.com/yourusername/java-master-quiz.git
cd java-master-quiz
```
2. Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, or VS Code).
3. Ensure the `src` directory is marked as the **Sources Root**.

### Generating Questions (Optional)
To populate the database with a fresh set of questions:
```bash
python tmp_generate_qs.py
```

## 🎮 Usage
1. Run `src/Main.java` to launch the application.
2. **Register** a new account or **Login** with existing credentials.
3. Select a category (e.g., Core Java, OOP) and start the quiz.
4. Keep an eye on the timer!
5. View your score and compare it on the Leaderboard.

---

## 📈 Development Journey (Changelog Guide)

*(This section is designed to guide developers through the 70+ commits that shaped the evolution of this project).*

<details>
<summary><b>Phase 1: Initial Setup & Base Models (Commits 1-10)</b></summary>

1. `init: Initialize Java project structure`
2. `feat: Create base User model class`
3. `feat: Add fields for username, password, and role in User model`
4. `feat: Create Question model class`
5. `feat: Add properties (text, options, correct answer, category) to Question`
6. `feat: Create QuizResult model class`
7. `feat: Add properties (score, total questions, user info) to QuizResult`
8. `chore: Setup data directory for file storage`
9. `feat: Create initial empty questions.txt file`
10. `feat: Create initial empty leaderboard.txt file`
</details>

<details>
<summary><b>Phase 2: Core Services & File Handling (Commits 11-20)</b></summary>

11. `feat: Create FileService class for generic file I/O`
12. `feat: Implement read methods in FileService`
13. `feat: Implement write methods in FileService`
14. `feat: Create AuthService for user authentication logic`
15. `feat: Implement user registration logic in AuthService`
16. `feat: Implement user login verification in AuthService`
17. `feat: Create QuizService for managing quiz flow`
18. `feat: Add method to load questions from text file in QuizService`
19. `feat: Create LeaderboardService to track high scores`
20. `feat: Implement save score and retrieve top scores functionality`
</details>

<details>
<summary><b>Phase 3: Basic UI Screens (Commits 21-30)</b></summary>

21. `feat: Setup basic LoginScreen layout using JFrame`
22. `feat: Add username and password fields to LoginScreen`
23. `feat: Link LoginScreen to AuthService`
24. `feat: Setup basic SignupScreen layout`
25. `feat: Add validation for signup inputs`
26. `feat: Link SignupScreen to AuthService`
27. `feat: Setup QuizScreen layout`
28. `feat: Add question label and radio buttons for options`
29. `feat: Setup ResultScreen layout`
30. `feat: Add score display and "play again" button to ResultScreen`
</details>

<details>
<summary><b>Phase 4: UI Modernization & Theming (Commits 31-40)</b></summary>

31. `refactor: Apply modern fonts (e.g., Arial, sans-serif) across all screens`
32. `style: Implement color palettes for light and dark themes`
33. `style: Update LoginScreen with modern button styling`
34. `style: Add hover effects to primary buttons`
35. `style: Remove default borders from text fields and add custom padding`
36. `feat: Add dynamic progress bar to QuizScreen`
37. `style: Modernize radio buttons in QuizScreen`
38. `style: Update ResultScreen with a card-like summary panel`
39. `style: Add background colors to indicate pass/fail on ResultScreen`
40. `feat: Implement basic screen transitions between Login and Quiz`
</details>

<details>
<summary><b>Phase 5: Advanced Quiz Features & Python Scripting (Commits 41-50)</b></summary>

41. `feat: Add categories support (e.g., Core Java, OOP, Collections)`
42. `feat: Create AdminPanel UI for managing questions`
43. `feat: Add functionality to add new questions via AdminPanel`
44. `feat: Add functionality to delete questions via AdminPanel`
45. `chore: Create tmp_generate_qs.py script for automated question generation`
46. `feat: Script logic to generate 'Core Java' questions`
47. `feat: Script logic to generate 'OOP' and 'Collections' questions`
48. `chore: Run script to populate categories with 20 questions each`
49. `refactor: Update QuizService to filter questions by selected category`
50. `feat: Add timer functionality per question in QuizScreen`
</details>

<details>
<summary><b>Phase 6: Bug Fixes & Refinement (Commits 51-60)</b></summary>

51. `fix: Resolve UI visibility issue where buttons wouldn't appear until hover`
52. `fix: Correct label overlapping issue on smaller screen sizes`
53. `fix: Ensure score calculates correctly when skipping questions`
54. `refactor: Optimize file reading using Buffered I/O streams`
55. `fix: Handle empty user input exceptions during login/signup`
56. `fix: Prevent out-of-bounds exception on the last question`
57. `refactor: Clean up unused imports and format Main.java`
58. `fix: Correct leaderboard sorting logic (descending order)`
59. `style: Add application icon to the main window frames`
60. `docs: Document main architecture and setup process`
</details>

<details>
<summary><b>Phase 7: Polish & Final Integrations (Commits 61-70+)</b></summary>

61. `feat: Integrate smooth animations on screen load`
62. `feat: Add visual feedback (green/red) when selecting answers`
63. `refactor: Centralize configuration constants (colors, file paths)`
64. `test: Add manual UI validation testing steps`
65. `chore: Remove deprecated methods from initial prototype`
66. `style: Improve layout padding and alignment in AdminPanel`
67. `feat: Add "Exit Application" confirmation dialog`
68. `docs: Update README with project structure and features`
69. `refactor: Decouple Main class from heavy UI initializations`
70. `chore: Final review and code cleanup`
</details>

---

## 🤝 Contributing
Contributions, issues, and feature requests are welcome! 
Feel free to check [issues page](https://github.com/yourusername/java-master-quiz/issues).

## 📄 License
This project is [MIT](https://choosealicense.com/licenses/mit/) licensed.

Made with ❤️ by Saurav Dhiman
