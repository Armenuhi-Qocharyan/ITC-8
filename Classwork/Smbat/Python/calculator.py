def sum(var1, var2):
    return var1 + var2
def sub(var1, var2):
    return var1 - var2
def mul(var1, var2):
    return var1 * var2
def div(var1, var2):
    if var2 == 0:
        return 
    return var1 / var2
    
if ( __name__ == '__main__' ):
    import argparse
    parser = argparse.ArgumentParser()
    parser.add_argument("-c", type=str, help="Enter in parametrs < -c 5,+,8 >")
    args = parser.parse_args()
    list=args.c.split(',')
    firstValue=int(list[0])
    action=list[1]
    secondValue=int(list[2])

    actions = {
        '+': sum(firstValue, secondValue),
        '-': sub(firstValue, secondValue),
        '*': mul(firstValue, secondValue),
        '/': div(firstValue, secondValue)
    }


    if action != "+" and action != "-" and action != "*" and action != "/":
        print('INVALED ACTION')
    elif action == '/' and secondValue == 0:
        print('Div on 0')
    else:
        print firstValue, action, secondValue, "=", actions[action]
