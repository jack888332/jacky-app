@ echo off
set /p start=确定更改文件名？(Y/N):
if /i "%start%" neq "Y" exit
setlocal enabledelayedexpansion
for /F "tokens=1 delims=" %%c in ('dir /b %~dp0') do (
    if %%c neq %~nx0 (
        set oldFileName=%%c
        set newFileName=!oldFileName:~10,-4!
        ren %~dp0!oldFileName! !newFileName!
    )
)
set number=0
for /F "tokens=1 delims=" %%c in ('dir /b /o:n %~dp0') do (
    if %%c neq %~nx0 (
        set /a number+=1
        set oldFileName=%%c
        set newFileName=!number!%%~xc
        ren %~dp0!oldFileName! !newFileName!
    )
)
echo 成功更改%number%个文件名。
endlocal
pause