package main

import (
	"fmt"
	"unicode"
)

func passwordChecker(pw string) bool {
	pwR := []rune(pw)
	if len(pwR) < 8 {
		return false
	}
	hasUpper := false
	hasLower := false
	hasNumber := false
	hasSymbol := false

	for _, v := range pwR {
		if unicode.IsUpper(v) {
			hasUpper = true
		}
		if unicode.IsLower(v) {
			hasLower = true
		}
		hasNumber = unicode.IsNumber(v)
		hasSymbol = unicode.IsPunct(v) || unicode.IsSymbol(v)
	}
	return hasUpper && hasLower && hasNumber && hasSymbol
}

func main() {
	if passwordChecker("") {
		fmt.Println("密碼格式良好")
	} else {
		fmt.Println("密碼格式不正確")
	}

	if passwordChecker("This!I5A") {
		fmt.Println("密碼格式良好")
	} else {
		fmt.Println("密碼格式不正確")
	}
}
