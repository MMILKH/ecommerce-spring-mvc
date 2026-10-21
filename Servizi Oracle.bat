@echo off
NET SESSION >nul 2>&1
if %errorLevel% neq 0 (
    echo [!] Esegui questo file come AMMINISTRATORE!
    echo Clicca con il tasto destro sul file e seleziona "Esegui come amministratore".
    pause
    exit /b
)

sc query "OracleServiceXE" | find "RUNNING" >nul
if %errorLevel% equ 0 (
    echo =========================================
    echo   ARRESTO SERVIZI ORACLE IN CORSO...
    echo =========================================
    net stop OracleServiceXE
    net stop OracleOraDB21Home1TNSListener
    echo.
    echo [OK] Servizi Oracle arrestati con successo! RAM liberata.
) else (
    echo =========================================
    echo   AVVIO SERVIZI ORACLE IN CORSO...
    echo =========================================
    net start OracleOraDB21Home1TNSListener
    net start OracleServiceXE
    echo.
    echo [OK] Oracle 21c e pronto per l'uso!
)

echo.
pause