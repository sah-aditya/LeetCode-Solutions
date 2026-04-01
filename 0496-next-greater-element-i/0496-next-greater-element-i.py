class Solution(object):
    def nextGreaterElement(self, nums1, nums2):
        stack = []
        d = {}
        for n in nums2:
            while stack and n > stack[-1]:
                d[stack.pop()] = n
            stack.append(n)
        for n in stack:
            d[n] = -1
        return [d[x] for x in nums1]