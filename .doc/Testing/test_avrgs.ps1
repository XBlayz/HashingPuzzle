$path_avr = ".\.doc\Testing\avrtimes"
$path_avr_all = $path_avr + ".csv"

$file0 = Get-Content -Path .\.doc\Testing\avrtimes-0.csv
$file1 = Get-Content -Path .\.doc\Testing\avrtimes-1.csv
$file2 = Get-Content -Path .\.doc\Testing\avrtimes-2.csv
$file3 = Get-Content -Path .\.doc\Testing\avrtimes-3.csv
$file4 = Get-Content -Path .\.doc\Testing\avrtimes-4.csv

"x, y" | Out-File -FilePath $path_avr_all -Encoding "UTF8"
for ($i = 1; $i -lt 33; $i++) {
    $avrs = ($file0[$i] -split ', ')[1], ($file1[$i] -split ', ')[1], ($file2[$i] -split ', ')[1], ($file3[$i] -split ', ')[1], ($file4[$i] -split ', ')[1]
    
    $value = 0
    for ($j = 0; $j -lt $avrs.Count; $j++) {
        $value += $avrs[$j]
    }
    $value = $value / $avrs.Count
    $value = $value -split ',' -join '.'
    $value = "$i, $value"
    
    Add-Content -Path $path_avr_all -Value $value -Encoding "UTF8"
}
Write-Host "DONE!"