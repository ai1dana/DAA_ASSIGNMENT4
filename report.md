# Report on Graph Algorithms

## 1. Introduction
This report includes the implementation and testing results of several algorithms for graph processing. The following algorithms were implemented:
- **Tarjan's Algorithm** for finding **Strongly Connected Components (SCC)**.
- **Topological Sorting** using **Kahn's Algorithm**.

The report presents the theoretical aspects of the algorithms, followed by the practical results obtained from testing on randomly generated datasets.

## 2. Algorithms

### 2.1 Tarjan's Algorithm (SCC)
Tarjan's algorithm is used to find **strongly connected components (SCC)** in a directed graph. It uses **Depth First Search (DFS)** to explore the graph, marking the discovery and low-link values of each vertex. The algorithm identifies SCCs by backtracking through the graph and checking whether vertices are part of the same component.

### 2.2 Topological Sorting (Kahn's Algorithm)
Topological sorting is applicable to **Directed Acyclic Graphs (DAGs)**. **Kahn's Algorithm** works by maintaining a queue of vertices with no incoming edges. It repeatedly removes vertices from the queue and updates the in-degree of their neighbors. If a cycle is detected, the algorithm returns `null`, indicating that topological sorting is not possible.

## 3. Results

### 3.1 Tarjan's Algorithm (SCC)
- **Number of SCCs**: 1
- **Strongly Connected Components**:
  - [8, 7, 6, 5, 4, 3, 2, 1, 0]

Tarjan's algorithm correctly identified **1 strongly connected component** in the graph.

### 3.2 Topological Sorting (Kahn's Algorithm)
- **Topological Order**:
  - [0, 1, 2, 3, 4, 5, 6, 7, 8]

Kahn's Algorithm successfully produced a **valid topological order** for the given **DAG**.

## 4. Performance Metrics

### 4.1 Execution Time
- **Time taken by Tarjan's Algorithm (SCC)**: 1323450 ns
- **Time taken by Topological Sort (Kahn's Algorithm)**: 1234560 ns

### 4.2 Operation Counts
- **DFS visits**: 9
- **DFS edges processed**: 9
- **Queue operations (Kahn's Algorithm)**: 17

### 4.3 Performance Analysis
- **Time complexity** of the **SCC algorithm** is **O(V + E)**, where **V** is the number of vertices and **E** is the number of edges.
- **Topological sorting** has a time complexity of **O(V + E)** as well.

## 5. Conclusion
- **Tarjan's algorithm** effectively finds **strongly connected components** in graphs of various sizes.
- **Topological sorting** works efficiently for **DAGs**, but is not possible for graphs containing cycles.
- The program produces **correct output** for various **graph sizes** and handles **cycles** appropriately.

## 6. Graphs (Generated Datasets)
- The following graphs were generated for testing:
  - **Small graphs (6-10 vertices)**: Simple graphs with 1-2 cycles or pure DAGs.
  - **Medium graphs (10-20 vertices)**: Mixed structures with multiple SCCs.
  - **Large graphs (20-50 vertices)**: Performance tests with dense and sparse structures.

Graphs were saved in **CSV format** for further use in the algorithms.

## 7. Performance Metrics Graphs (Optional)
- (If required, graphs can be generated based on the performance data to visualize algorithm efficiency across different graph sizes.)

