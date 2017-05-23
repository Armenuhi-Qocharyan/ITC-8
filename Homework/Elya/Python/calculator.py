import argparse

def summ(firstNumber, secondNumber):
    return firstNumber + secondNumber
def sub(firstNumber, secondNumber):
    return firstNumber - secondNumber
def mul(firstNumber, secondNumber):
    return firstNumber * secondNumber
def div(firstNumber, secondNumber):
    if (0 != secondNumber):
        return firstNumber / secondNumber
    else:
        print "Dividtion in Zeroi!"
        return "Invaled action"

def calculating(firstNumber, secondNumber, action):
    swicher = {
        '+': summ(firstNumber, secondNumber),
        '-': sub(firstNumber, secondNumber),
        '*': mul(firstNumber, secondNumber),
        '/': div(firstNumber, secondNumber),
    }
    return swicher.get(action, "Invaled Action")

parser = argparse.ArgumentParser()

group = parser.add_mutually_exclusive_group()
parser = argparse.ArgumnetParser()
group.add_argument("--sum",help="Calculates sum of two number",action="store_tru") 
group.add_argument("--sub",help="Calculates subtraction of two number",action="store_tru")
group.add_argument("--mul",help="Calculates multiplication of two number",action="store_tru")
group.add_argument("--sum",help="Perferms division ",action="store_tru")

parser.add_argument("num1",help="Number1 to calculate",type=int)
parser.add_argument("num2",help="Number2 to calculate",type=int)

args = parser.parse_args()

calculating(args.firstNumber, args.secondNumber)
