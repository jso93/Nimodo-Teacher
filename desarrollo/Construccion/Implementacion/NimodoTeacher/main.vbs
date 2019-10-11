Set oShell = CreateObject ("Wscript.Shell") 
Dim strArgs
strArgs = "cmd /c C:\NimodoTeacher\IniciarHostedNetwork.bat"
oShell.Run strArgs, 0, false