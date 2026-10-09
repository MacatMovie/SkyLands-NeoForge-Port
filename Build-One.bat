@echo off
setlocal EnableExtensions DisableDelayedExpansion
if /i "%~1"=="--console" goto build
rem A persistent child console handles Explorer/cmd-c launches, including spaces.
"%ComSpec%" /d /k call "%~f0" --console
exit /b

:build
pushd "%~dp0"
if errorlevel 1 goto directory_error
echo SkyLands - Unofficial Port - NeoForge 1.21.1 - v0.9.0
echo Runtime requires TerraBlender NeoForge 1.21.1 4.1.0.8 or newer within 4.1.
echo Runtime also requires GeckoLib NeoForge 1.21.1 4.7.6 or newer within GeckoLib 4.
echo Client runtime also requires Player Animator NeoForge 1.21.1 2.0.1 or newer within 2.x.
echo Requires a Java 21 JDK and Gradle 8.13 or newer within Gradle 8.
set "gradle_command="
rem Use the user's shared installations. Do not invoke/download a wrapper.
rem Gradle 9 is deliberately excluded for this NeoGradle 7.0 project.
for %%V in (8.14.4 8.14.3 8.14.2 8.14.1 8.14 8.13) do if not defined gradle_command if exist "C:\Gradle\gradle-%%V\bin\gradle.bat" set "gradle_command=C:\Gradle\gradle-%%V\bin\gradle.bat"
if not defined gradle_command goto gradle_missing
echo Using "%gradle_command%"
echo.
call "%gradle_command%" --no-daemon build
set "build_result=%errorlevel%"
echo.
if "%build_result%"=="0" (
    echo BUILD SUCCESSFUL. The mod JAR is dist\SkyLands-UnofficialPort-NeoForge-1.21.1-v0.9.0.jar.
) else (
    echo BUILD FAILED with exit code %build_result%.
    echo Copy the error output above when reporting the failure.
)
popd
echo.
pause
exit /b %build_result%

:gradle_missing
echo.
echo No compatible shared Gradle installation was found in C:\Gradle.
echo Expected C:\Gradle\gradle-8.14.4\bin\gradle.bat
echo Gradle 8.14.3 through 8.13 are also accepted. Gradle 9 is not selected.
popd
pause
exit /b 1

:directory_error
echo Could not open the project directory.
pause
exit /b 1
