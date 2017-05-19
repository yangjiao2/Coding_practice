"""Identify whether four sides (given by four integers) can form a square, a rectangle, or neither.

Input: You will receive an list of strings, each containing four space-separated integers,
which represent the length of the sides of a polygon. The input lines will follow the 'A B C D' order as in the following representation:
"""

input1="""36 30 36 30
15 15 15 15
46 96 90 100
86 86 86 86
100 200 100 200
-100 200 -100 200"""

output_expected = """2 2 2"""

def sol1(input1):
    result = [0, 0, 0] # square, rectable, polygon
    lines = input1.split("\n")
    for row in lines:
        row = row.split(" ")
        if list(filter(lambda x: "-" in x, row)):
            result[2] += 1
        elif row[0] == row[2] and row[1] == row[3] and row[0] != row[1]:
            result[1] += 1
        elif row[0] == row[2] == row[1] == row[3]:
            result[0] += 1
    
    return " ".join([str(result[0]), str(result[1]), str(len(lines)-int(result[0])- int(result[1]))])
# print sol1(input1)
            

"""Given a list of numbers, e.g.:

25626 25757 24367 24267 16 100 2 7277
Output a delta encoding for the sequence. """

input2="25626 25757 24367 24267 16 100 2 7277"
output_expected = "25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275"

def sol2(input2):
    seq = input2.split(" ")
    sub = list(map(lambda (x, y): int(x) - int(y), zip(seq + ["0"], ["0"] + seq)))
    result = []
    for element in sub[:-1]:
        if int(element) > 0:
            result.append(str(element))
        else:
            result.append("-128 " + str(element))
    
    return " ".join(result)

# print sol2(input2)

"""Within an output string, the expression should be sorted lexicographically.
If a group contains only a single element,
output that one-element group as a single string.
And the string should be also output in lexicographical order. Given e.g.:
"""

input3 = """pear
amleth
dormitory
tinsel
dirty room
hamlet
listen
silnet"""

output_expected = """amleth,hamlet
dirty room,dormitory
listen,silnet,tinsel
pear"""

import collections

def earliestin(wordbank, word):
    if len(word) > 0:
        earliest = wordbank[word[0]]
    for i in range(1, len(word)):
        if 0 <= ord(word[i]) - ord('a') <= 25:
            earliest = earliest.intersection(wordbank[word[i]])

    return -1 if len(earliest) == 0 else list(sorted(earliest))[0]
    
def sol3(input3):
    words = input3.lower().split("\n")
    wordbank = collections.defaultdict(lambda: set())
    result = [[] for i in range(len(words))]
    for i in range(len(words)):
        found = earliestin(wordbank, words[i])
        if found != -1:
            result[found].append(words[i])
        else: 
            for char in words[i]:
                if 0 <= ord(char) - ord('a') <= 25:
                    wordbank[char].add(i)
            result[i].append(words[i])
    
    sorted_result = [sorted(ana) for ana in result if ana != []]
    sorted_result.sort(key = lambda row: row[0])

    return "\n".join([",".join(element) for element in sorted_result ])

#print sol3(input3)


"""Identify whether there exists a pair of numbers in an array such that their sum is equal to N."""
input4 = """66
10
18
11
21
28
31
38
40
55
60
62"""

output_expected = "1"

def sol4(input4):
    numbers = input4.split("\n")
    sumnum = numbers[0]
    addernum = input4.split("\n")[1:]
    inneed = []
    for ele in addernum:
        if int(ele) in inneed:
            return 1
        else:
            inneed.append(int(sumnum) - int(ele))
    return 0

print sol4(input4)
print output_expected

    

