# Complete the function below.


def gcd(*numbers):
    from fractions import gcd
    return reduce(gcd, numbers)

def lcm(*numbers):
    def lcm(a, b):
        return (a * b) // gcd(a, b)
    return reduce(lcm, numbers, 1)

def  fractionSum(str):
    result = []
    for elements in str:
        num1, den1 = elements.split("+")[0].split("/")
        num2, den2 = elements.split("+")[-1].split("/")
        num1 = int(num1)
        num2 = int(num2)
        den1 = int(den1)
        den2 = int(den2)
        thislcm = lcm(den1, den2)

        numsum = (thislcm // den1) * num1 + (thislcm // den2) * num2
        thislcd = gcd(numsum, thislcm)

        resultnum = numsum // thislcd
        resultden = thislcm // thislcd
        result.append( resultnum.__str__() + "/" + resultden.__str__())

return result



# Complete the function below.


def  countX(steps):
    xstep = []
    ystep = []
    for step in steps:
        x, y = step.split(" ")
        x = int(x)
        y = int(y)
        xstep.append(x)
        ystep.append(y)
    return min(xstep) * min(ystep)
    
        
    # Complete the function below.
import collections
def  getMinimumDifference(a, b):    
    if len(a) != len(b): return []
    result = []
    
    for i in range(len(a)):
        sum = 0
        countera = collections.Counter(a[i])
        counterb = collections.Counter(b[i])

        for key, value in countera.iteritems():
            if key in list(counterb.keys()):
               sum += max(0, countera[key] - counterb[key])
            else:
               sum += countera[key]
        for key, value in counterb.iteritems():
            if key in list(countera.keys()):
               sum += max(0, counterb[key] - countera[key])
            else:
               sum += counterb[key]
  
        if len(a[i]) != len(b[i]):
            result.append(-1)
        else:
            result.append(sum / 2)
            
    return result



# Complete the function below.

import collections
def  countHoles(num):
    holedict = dict()
    for holenum, group in enumerate([[1,2,3,5,7], [0,4,6,9], [8]]):
        for element in group:
            holedict[element] = holenum
    numlist = []
    numstr = str(num)
    for i in range (len(numstr)):
        numlist.append(holedict[int(numstr[i])])
    return reduce(lambda x, y: x + y, numlist)
            
            
