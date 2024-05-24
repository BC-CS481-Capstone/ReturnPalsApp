package com.example.returnpals.services.backend

import android.util.Log
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.Model

/**
 * Encapsulates create, read, update, and delete (CRUD) operations for a specified data model
 * using [GraphQL API](https://docs.amplify.aws/gen1/android/build-a-backend/graphqlapi/).
 * @param type ModelType cannot be reified so type information needs to be passed at runtime.
 */
open class ModelRepository<ModelType>(
    private val type: Class<ModelType>
) where ModelType : Model {

    fun create(model: ModelType): ModelType? {
        var result: ModelType? = null
        Amplify.API.mutate(
            ModelMutation.create(model),
            { response ->
                // NOTE: A successful GraphQL response doesn't always mean that the user was successfully created.
                if (response.hasErrors()) {
                    var errors = ""
                    response.errors.forEachIndexed { index, error -> errors += "[$index] ${error.message}\n" }
                    Log.w("ModelRepository<${type.simpleName}>", "Failed to create ${model.modelName} due to GraphQL errors:\n$errors")
                } else if (!response.hasData()) {
                    Log.w("ModelRepository<${type.simpleName}>", "Failed to create ${model.modelName}. GraphQL response is empty.")
                } else {
                    result = response.data
                    Log.i("ModelRepository<${type.simpleName}>", "Created ${result?.modelName} with primary key: ${result?.primaryKeyString}")
                }
            },
            { exception ->
                Log.e("ModelRepository<${type.simpleName}>", "Failed to create ${model.modelName}. Amplify API threw exception:\n" +
                        exception.message + '\n' + exception.cause + '\n' + exception.recoverySuggestion + '\n')
            }
        )
        return result
    }

    fun delete(model: ModelType): ModelType? {
        var result: ModelType? = null
        Amplify.API.mutate(
            ModelMutation.delete(model),
            { response ->
                if (response.hasErrors()) {
                    var errors = ""
                    response.errors.forEachIndexed { index, error -> errors += "[$index] ${error.message}\n" }
                    Log.e("ModelRepository<${type.simpleName}>", "Failed to delete ${model.modelName} due to GraphQL errors:\n$errors")
                } else if (!response.hasData()) {
                    Log.e("ModelRepository<${type.simpleName}>", "Failed to delete ${model.modelName}. GraphQL response is empty.")
                } else {
                    result = response.data
                    Log.i("ModelRepository<${type.simpleName}>", "Deleted ${result?.modelName} with primary key: ${result?.primaryKeyString}")
                }
            },
            { exception ->
                Log.e("ModelRepository<${type.simpleName}>", "Failed to delete ${model.modelName}. Amplify API threw exception:\n" +
                        exception.message + '\n' + exception.cause + '\n' + exception.recoverySuggestion + '\n')
            }
        )
        return result
    }

    fun update(model: ModelType): Boolean {
        var result = false
        Amplify.API.mutate(
            ModelMutation.update(model),
            { response ->
                if (response.hasErrors()) {
                    var errors = ""
                    response.errors.forEachIndexed { index, error -> errors += "[$index] ${error.message}\n" }
                    Log.e("ModelRepository<${type.simpleName}>", "Failed to update ${model.modelName} due to GraphQL errors:\n$errors")
                } else if (!response.hasData()) {
                    Log.e("ModelRepository<${type.simpleName}>", "Failed to update ${model.modelName}. GraphQL response is empty.")
                } else {
                    result = true
                    Log.i("ModelRepository<${type.simpleName}>", "Updated ${response.data.modelName} with primary key: ${response.data.primaryKeyString}")
                }
            },
            { exception ->
                Log.e("ModelRepository<${type.simpleName}>", "Failed to update ${model.modelName}. Amplify API threw exception:\n" +
                        exception.message + '\n' + exception.cause + '\n' + exception.recoverySuggestion + '\n')
            }
        )
        return result
    }

    operator fun get(id: String): ModelType? {
        var result: ModelType? = null
        Amplify.API.query(
            ModelQuery[type, id],
            { response ->
                if (response.hasErrors()) {
                    var errors = ""
                    response.errors.forEachIndexed { index, error -> errors += "[$index] ${error.message}\n" }
                    Log.e("ModelRepository<${type.simpleName}>", "Failed to retrieve $type due to GraphQL errors:\n$errors")
                } else if (response.hasData()) {
                    result = response.data
                    Log.i("ModelRepository<${type.simpleName}>", "Retrieved ${result?.modelName} with primary key: ${result?.primaryKeyString}")
                }
            },
            { exception ->
                Log.e("ModelRepository<${type.simpleName}>", "Failed to update $type. Amplify API threw exception:\n" +
                        exception.message + '\n' + exception.cause + '\n' + exception.recoverySuggestion + '\n')
            }
        )
        return result
    }

}