#!/usr/bin/env python
# coding: utf-8

# In[1]:


def selectionSortAsc(data):
    for i in range(len(data) - 1):
        for j in range(i + 1, len(data), 1):
            if data[i] > data[j]:
                data[i], data[j] = data[j], data[i]
    return data


# In[2]:


def selectionSortDesc(data):
    for i in range(len(data) - 1):
        for j in range(i + 1, len(data), 1):
            if data[i] < data[j]:
                data[i], data[j] = data[j], data[i]
    return data


# In[3]:


if __name__ == "__main__":
    data = [8, 3, 4, 9, 1]
    result = selectionSortAsc(data)
    print("오름차순 정렬 결과 : {}".format(result))
    result = selectionSortDesc(data)
    print("내림차순 정렬 결과 : {}".format(result))


# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:




