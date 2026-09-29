class Solution(object):
    def mostPopularCreator(self, creators, ids, views):
        """
        :type creators: List[str]
        :type ids: List[str]
        :type views: List[int]
        :rtype: List[List[str]]
        """
        data = {}    
        for c, i, v in zip(creators, ids, views):
            if c not in data:
                data[c] = [0, -1, ""]
            
            data[c][0] += v
            current_max_views = data[c][1]
            current_best_id = data[c][2]
            if v > current_max_views or (v == current_max_views and i < current_best_id):
                data[c][1] = v
                data[c][2] = i
                
        max_popularity = 0
        for stats in data.values():
            if stats[0] > max_popularity:
                max_popularity = stats[0]
                
        result = []
        for creator, stats in data.items():
            if stats[0] == max_popularity:
                result.append([creator, stats[2]])
                
        return result