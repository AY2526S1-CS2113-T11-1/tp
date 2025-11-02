@echo off
setlocal enableextensions
pushd %~dp0
echo Killing lingering java processes...
taskkill /IM javaw.exe /F >nul 2>nul
taskkill /IM java.exe /F >nul 2>nul
cd ..
call gradlew clean shadowJar

cd build\libs
for /f "tokens=*" %%a in (
    'dir /b *.jar'
) do (
    set jarloc=%%a
)

java -jar %jarloc% --test < ..\..\text-ui-test\input.txt > ..\..\text-ui-test\ACTUAL.TXT

cd ..\..\text-ui-test
ECHO Test passed! || Echo Test failed!
FC ACTUAL.TXT EXPECTED.TXT
