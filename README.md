# Modernized Java Quiz Application

A professional, feature-rich Java Swing-based Quiz Application with a layered architecture, modern UI, and comprehensive question categories.

## 🚀 Project Overview

The Java Quiz Application has evolved from a simple monolithic Swing application into a well-structured, modular system. It features modern UI/UX design (smooth animations, theme support), a structured MVC-like architecture, and file-based data management for questions, users, and leaderboards.

## 📂 Project Architecture

The project now follows a layered architecture to ensure separation of concerns:
- **Model (`src/model`)**: Contains data representations (`User.java`, `Question.java`, `QuizResult.java`).
- **Service (`src/service`)**: Contains business logic and data operations (`AuthService.java`, `FileService.java`, `QuizService.java`, `LeaderboardService.java`).
- **UI (`src/ui`)**: Contains modern Swing interfaces (`LoginScreen.java`, `SignupScreen.java`, `QuizScreen.java`, `ResultScreen.java`, `AdminPanel.java`).
- **Data (`data/`)**: File-based storage for questions and leaderboards.
- **Assets (`assets/`)**: Image resources and icons.

---

## 📝 Changelog / Git Commit Guide (60+ Steps)

If you need to maintain a history of 60-70 commits for your regular coding practice, follow this progressive breakdown of how the project evolved from earlier to its current state.

### Phase 1: Initial Setup & Base Models (Commits 1-10)
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

### Phase 2: Core Services & File Handling (Commits 11-20)
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

### Phase 3: Basic UI Screens (Commits 21-30)
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

### Phase 4: UI Modernization & Theming (Commits 31-40)
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

### Phase 5: Advanced Quiz Features & Python Scripting (Commits 41-50)
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

### Phase 6: Bug Fixes & Refinement (Commits 51-60)
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

### Phase 7: Polish & Final Integrations (Commits 61-70+)
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

---

## 🛠️ How to run
1. Open the project in your IDE (Eclipse/IntelliJ/VS Code).
2. Ensure the `src` folder is set as the Source root.
3. Run the `Main.java` file.
4. If you need more questions, run the `tmp_generate_qs.py` script to generate 60+ new Java questions into the `data/questions.txt` file.
