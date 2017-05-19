import re
def wrapText(text, maxPerline):
    if text == "" or text == None or maxPerline == 0:
        return ""
    result = ""
    lineList = text.split("\n")

    for i in range (len(lineList)):
     
        result += processWord(lineList[i], maxPerline)
        result += "\n"
    return result [: -1]

def processWord(inputword, maxPerline):
    result = ""
    wordList = re.sub(" +", " ", inputword).split(" ")
    cursor = -1
    i = 0
    while(i < (len(wordList))):
        wordlen = len(wordList[i])
        word = wordList[i]

        if wordlen != 0:

            if (cursor + wordlen + 1 <= maxPerline):
                if cursor != -1:
                    result += " "
                result += word
                cursor += 1 + wordlen
            elif (cursor + wordlen + 1 > maxPerline and cursor == -1 and wordlen > maxPerline):
                for j in range(wordlen // maxPerline):
                    result += word[j*maxPerline: (j+1)*maxPerline] + "\n"
                wordleft = word[(wordlen // maxPerline) * maxPerline: ]
                result += wordleft
                cursor = len(wordleft) - 1
            elif (cursor + wordlen + 1 > maxPerline and cursor != -1):
                i = i - 1
                result += "\n"
                cursor = -1
        i = i + 1

    return result
                
print wrapText("123.\n \n \n 456789", 5)  
print wrapText("\ndf   eg \n2  ..", 3)
