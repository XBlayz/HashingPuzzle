$java = 'C:\Program Files\Eclipse Adoptium\jdk-17.0.2.8-hotspot\bin\java.exe'
$jvm_args = '@C:\Users\Utente\AppData\Local\Temp\cp_ahx7pwvihuhlfuylnovli8ask.argfile'
$app = 'xblayz.App'

$path_avr = ".\.doc\Testing\avrtimes"
$path_runs = ".\.doc\Testing\runtimes"

# SETUP
$S = "Test-String-", "Prova-Stringa-", "String-Test-", "Stringa-Prova-", "SisOp-Course A-Hashing-Puzzle-"
$D = 6 # 6
$max_thread = 32 # 32
$n_run = 5 # 5

# CODE
$n_point = $max_thread*$n_run

$avrs = New-Object 'string[][]' ($max_thread,2)
$runs = New-Object int[][] ($n_point,2)

for ($s_i = 0; $s_i -lt $S.Count; $s_i++) {
    for ($i = 1; $i -lt ($max_thread+1); $i++) {
        $avr = 0
        for ($j = 0; $j -lt $n_run; $j++) {
            Write-Host "Run-$j ($i thread): " -NoNewline
            $out = (& $java $jvm_args $app $S[$s_i] $D $i) | Out-String
            $out = $out.Split([Environment]::NewLine)
            Write-Host $out[0]

            $avr += [int]$out[0]

            $runs[(($i-1)*$n_run)+$j] = $i, [int]$out[0]
        }
        $avr = $avr / $n_run
        $avr = $avr -split ',' -join '.'
        Write-Host "AVR($i thread): $avr"

        $avrs[$i-1] = $i, $avr
    }
    $path_avr_ = $path_avr + "-" + $s_i + ".csv"
    $path_runs_ = $path_runs + "-" + $s_i + ".csv"

    "x, y" | Out-File -FilePath $path_avr_ -Encoding "UTF8"
    "x, y" | Out-File -FilePath $path_runs_ -Encoding "UTF8"
    foreach ($point in $avrs) {
        $str = $point -join ', '
        Add-Content -Path $path_avr_ -Value $str -Encoding "UTF8"
    }
    foreach ($point in $runs) {
        $str = $point -join ', '
        Add-Content -Path $path_runs_ -Value $str -Encoding "UTF8"
    }
}

Write-Host ""
Write-Host "DONE!"