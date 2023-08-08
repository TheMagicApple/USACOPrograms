#!/bin/bash
# Author: Steven Lee
# WhizKidz Computer Center
#
# History of Change
# 08/01/19: Modified to handle any number of test cases.
#           Can specify a specific test case to run.
# 09/07/19: Git diff requires -w to ignore differences in CR/LF and LF
# 02/20/21: Starting with the December 2020 contests, input/output uses
#   standard in/out instead of a file so test basename is no longer needed.
#   Output is written to a file named data.out.

if [ $# -lt 1 ]; then
	echo "Usage: $0 <Java class> [all | test case #]" >&2
    echo "Examples:" >&2
    echo "  # Run the first test case only." >&2
    echo "  $0 Teleportation" >&2
    echo >&2
    echo "  # Run test case 3." >&2
    echo "  $0 Teleportation 3" >&2
    echo >&2
    echo "  # Run all test cases." >&2
    echo "  $0 Teleportation all" >&2
	exit 2
fi

jclass="$1"

first=1
if [ "$2" = "all" ]; then
    all=true
else
    all=
    if [ -n "$2" ]; then
        first="$2"
    fi
fi

# If running Eclipse, class files are in the 'bin' directory.
java_args=
if [ -d "bin" ]; then
    java_args="-cp bin"
fi

i="$first"
while [ -f "data/$i.in" -a \( $i -eq $first -o "$all" \) ]; do
	echo "File: $i.in"
	java $java_args $jclass < data/$i.in > data.out
	diff -w data/$i.out data.out
    ((i++))
	echo
done
