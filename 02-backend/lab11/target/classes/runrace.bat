@echo off
cls
echo Working. Please wait . . .
java SortPerf select 5 1000 r 1000 select.dat
java SortPerf bubble 5 1000 r 1000 bubble.dat
java SortPerf insert 5 1000 r 1000 insert.dat
java SortPerf merge 5 1000 r 1000 merge.dat
java SortPerf quick 5 1000 r 1000 quick.dat
java SortPerf heap 5 1000 r 1000 heap.dat
rem pause
gnuplot -persist plot_command
echo on