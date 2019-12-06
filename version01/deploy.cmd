@set SERVER_HTML_FOLDER=c:\nginx-1.17.6\html
if "%1"=="" (
	set folder=%SERVER_HTML_FOLDER%
) else (
	set folder=%1
)

copy *.html %folder%
copy css\*.* %folder%\css
copy js\*.* %folder%\js