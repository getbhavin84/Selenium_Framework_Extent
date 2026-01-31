@echo off
setlocal
echo Running Automation Tests...

cd /d "F:\SELQEDGE\Selenium_Framework_Extent"
call mvn clean test

echo.
echo ===== TEST EXECUTION COMPLETED =====

pause
