@echo off
:: Launch FindBugs on a Windows system.
:: Adapted from scripts found at http://www.ericphelps.com/batch/
:: This will only work on Windows NT or later!

:: ----------------------------------------------------------------------
:: Set up default values
:: ----------------------------------------------------------------------
set appjar=findbugsGUI.jar
set jvmargs=
set javacmd=java
set debugArg=
set args=
set javaProps=
set start=
set maxheap=256

:: Honor JAVA_HOME environment variable if it is set
if "%JAVA_HOME%"=="" goto nojavahome
if not exist %JAVA_HOME%\bin\javaw.exe goto nojavahome
set javacmd=%JAVA_HOME%\bin\javaw
set start=start "FindBugs"
set javacmd=%JAVA_HOME%\bin\java
:nojavahome

goto loop

:: ----------------------------------------------------------------------
:: Process command-line arguments
:: ----------------------------------------------------------------------

:shift2
shift
:shift1
shift

:loop

:: Remove surrounding quotes from %1 and %2
set firstArg=%~1
set secondArg=%~2

if "%firstArg%"=="-gui" set appjar=findbugsGUI.jar
if "%firstArg%"=="-gui" goto shift1

if "%firstArg%"=="-textui" set appjar=findbugs.jar
if "%firstArg%"=="-textui" goto shift1

if "%firstArg%"=="-home" set FINDBUGS_HOME=%secondArg%
if "%firstArg%"=="-home" goto shift2

if "%firstArg%"=="-jvmArgs" set jvmargs=%secondArg%
if "%firstArg%"=="-jvmArgs" goto shift2

if "%firstArg%"=="-maxHeap" set maxheap=%secondArg%
if "%firstArg%"=="-maxHeap" goto shift2

if "%firstArg%"=="-debug" set debugArg=-Dfindbugs.debug=true
if "%firstArg%"=="-debug" goto shift1

if "%firstArg%"=="-javahome" set javacmd=%secondArg%\bin\java
if "%firstArg%"=="-javahome" goto shift2

if "%firstArg%"=="-property" set javaProps=-D%secondArg% %javaProps%
if "%firstArg%"=="-property" goto shift2

if "%firstArg%"=="-help" goto help

if "%firstArg%"=="" goto launch

set args=%args% "%firstArg%"
goto shift1

:: ----------------------------------------------------------------------
:: Launch FindBugs
:: ----------------------------------------------------------------------
:launch
:: Make sure FINDBUGS_HOME is set.
:: Note that this will fail miserably if the value of FINDBUGS_HOME
:: has quote characters in it.
if not "%FINDBUGS_HOME%"=="" goto found_home
set FINDBUGS_HOME=%~dp0..
if not exist %FINDBUGS_HOME%\lib\%appjar% goto homeNotSet

:found_home
:: echo FINDBUGS_HOME is %FINDBUGS_HOME%
:: echo appjar is %appjar%
:: echo args is %args%
:: echo jvmargs is %jvmargs%
%start% "%javacmd%" %debugArg% %javaProps% "-Dfindbugs.home=%FINDBUGS_HOME%" -Xmx%maxheap%m %jvmargs% -jar "%FINDBUGS_HOME%\lib\%appjar%" %args%
goto end

:: ----------------------------------------------------------------------
:: Display usage information
:: ----------------------------------------------------------------------
:help
echo Usage: findbugs [options] 
echo    -home dir       Use dir as FINDBUGS_HOME
echo    -gui            Use the Graphical UI (default behavior)
echo    -textui         Use the Text UI
echo    -jvmArgs args   Pass args to JVM
echo    -maxHeap size   Set maximum Java heap size in megabytes (default %maxheap%)
echo    -javahome dir   Specify location of JRE
echo    -help           Display this message
echo    -debug          Enable debug tracing in FindBugs
echo All other options are passed to the FindBugs application
goto end

:: ----------------------------------------------------------------------
:: Report that FINDBUGS_HOME is not set (and was not specified)
:: ----------------------------------------------------------------------
:homeNotSet
echo Could not find FindBugs home directory.  There may be a problem
echo with the FindBugs installation.  Try setting FINDBUGS_HOME, or
echo re-installing.
goto end

:end
