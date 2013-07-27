from math import log
import operator

# function to calculate the ShannonEntropy of a Dataset
def calcShannonEnt(dataSet):
  numEntries = len(dataSet)
  labelCounts = {}
  
  # create a dictionary of all possible classes
  for featVec in dataSet:
    currentLabel = featVec[-1]
    
    if currentLabel not in labelCounts.keys():
      labelCounts[currentLabel] = 0
    
    labelCounts[currentLabel] +=1
  
  shannonEnt = 0.0
  
  for key in labelCounts:
    prob = float(labelCounts[key])/numEntries
    shannonEnt -= prob* log(prob,2) # logarith base 2
  
  return shannonEnt
  
def createDataSet():
  dataSet = [ [1, 1, 'yes'],
	      [1, 1, 'yes'],
	      [1, 0, 'no'],
	      [0, 1, 'no'],
	      [0, 1, 'no'] ]
  labels = ['no surfacing', 'flippers']
  
  return dataSet, labels
  
# Dataset spliiting on a give feature
def splitDataSet(dataSet, axis, value):
  # create Separate List
  retDataSet = []
  
  for featVec in dataSet:
     if featVec[axis] == value :
       # cut out feature split on
       reducedFeatVec = featVec[:axis]
       reducedFeatVec.extend(featVec[axis + 1:])
       retDataSet.append(reducedFeatVec)
  
  return retDataSet
  
# choosing the best feature to split on
def chooseBestFeatureToSplit(dataSet):
  numFeatures = len(dataSet[0]) - 1
  
  baseEntropy = calcShannonEnt(dataSet)
  
  bestInfoGain = 0.0
  bestFeature = -1
  
  for i in range(numFeatures):
    # create unique list of Class Labels
    featList = [example[i] for example in dataSet]
    uniqueVals = set(featList)
    
    newEntropy = 0.0
    
    # calulate the entropy for each split
    for value in uniqueVals:
      subDataSet = splitDataSet(dataSet, i, value)
      prob = len(subDataSet)/float(len(dataSet))
      newEntropy += prob * calcShannonEnt (subDataSet)
    
    infoGain = baseEntropy - newEntropy
    
    # find the best information gain
    if (infoGain > bestInfoGain):
      bestInfoGain = infoGain
      bestFeature = i
   
  return bestFeature

def majorityCnt(classList):
  classCount = {}
  
  for vote in classList:
    if vote not in classCount.keys():
      classCount[vote] = 0
    
    classCount[vote] += 1
  
  sortedClassCount = sorted(classCount.iteritems(), key = operator.itemgetter(1), reverse = True)
  
  return sortedClassCount[0][0]

# Tree building code
def createTree(dataSet, labels):
  classList = [example[-1] for example in dataSet]
  
  # stop when all classes are equal
  if classList.count(classList[0]) == len(classList):
    return classList[0]
  
  # when there are no more features, return majority
  if len(dataSet[0]) == 1:
    return majorityCnt(classList)
  
  bestFeat = chooseBestFeatureToSplit(dataSet)
  bestFeatLabel = labels[bestFeat]
  
  myTree = {bestFeatLabel : {}}
  
  # get list of unique values
  del(labels[bestFeat])
  featValues = [example[bestFeat] for example in dataSet]
  uniqueVals = set(featValues)
  
  for value in uniqueVals:
    subLabels = labels[:]
    myTree[bestFeatLabel][value] = createTree(splitDataSet(dataSet, bestFeat, value), subLabels)
  
  return myTree