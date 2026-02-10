\# Application - Gradle Commands



\## Basic Commands



\# Run the  application

./gradlew run



\# Or use the custom task

./gradlew runDemo



\# Run all tests

./gradlew test


\# Clean build artifacts

./gradlew clean



\# Build the project

./gradlew build



\# Run Checkstyle

./gradlew checkstyleMain -PstaticAnalysis=true



\# Run SpotBugs

./gradlew spotbugsMain -PstaticAnalysis=true



\# Run all static analysis checks

./gradlew check -PstaticAnalysis=true



\# Generate JaCoCo coverage report (runs automatically after tests)

./gradlew test



\# View report at: build/reports/jacoco/test/html/index.html



\## Test Reports



After running tests, view HTML reports at:

\- \*\*All tests\*\*: `build/reports/tests/test/index.html`

